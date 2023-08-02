package livraria.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import livraria.model.Autor;
import livraria.model.Editora;
import livraria.model.Estilo;
import livraria.model.Livro;
import livraria.repository.AutorRepository;
import livraria.repository.EditoraRepository;
import livraria.repository.EstiloRepository;
import livraria.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	private LivroRepository repository;
	private AutorRepository autorRepository;
	private EditoraRepository editoraRepository;
	private EstiloRepository estiloRepository;
	
	@Autowired
	public LivroController(LivroRepository repository,
			AutorRepository autorRepository,
			EditoraRepository editoraRepository,
			EstiloRepository estiloRepository) {
		
		this.repository = repository;
		this.autorRepository = autorRepository;
		this.editoraRepository = editoraRepository;
		this.estiloRepository = estiloRepository;
	}
	
	@GetMapping
	public List<Livro> listLivro(){
		
		return repository.findAll();
	}
	
	@GetMapping(value = "editar")
	public Livro buscarPorId(@RequestParam Long id) {
		Optional<Livro> liv = repository.findById(id);
		Livro livro = liv.get();
		
		return livro;
	}
	
	@GetMapping(value = "buscar")
	public List<Livro> buscarPorParamento(@RequestParam(required = false) String titulo ){
		
		
		
		
		
		List<Livro> resultado = repository.findByTitulo(titulo = "%"+titulo+"%");
		return resultado;
		
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	
	public Livro salvar(
			@RequestBody Livro livro,
			@RequestParam(value= "autor_id") Long autor_id,
			@RequestParam(value= "editora_id") Long editora_id,
			@RequestParam(value= "estilo_id") Long estilo_id
			) {
		 
		Optional<Autor> autor = autorRepository.findById(autor_id);
		Optional<Editora> editora = editoraRepository.findById(editora_id);
		Optional<Estilo> estilo = estiloRepository.findById(estilo_id);
		
			
		livro.setAutor(autor.get());
		livro.setEditora(editora.get());
		livro.setEstilo(estilo.get());
		
		 return repository.save(livro);
		
		
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@RequestParam Long id) {
		repository.deleteById(id);
	}

}
