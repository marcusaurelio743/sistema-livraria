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

import livraria.model.Editora;
import livraria.repository.EditoraRepository;

@RestController
@RequestMapping("/editora")
public class EditoraController {
	private EditoraRepository repository;
	
	@Autowired
	public EditoraController(EditoraRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Editora> listEditora(){
		return repository.findAll();
	}
	
	@GetMapping(value = "editar")
	public Editora buscarporId(@RequestParam Long id) {
		Optional<Editora> editora = repository.findById(id);
		
		Editora objeto = editora.get();
		
		return objeto;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Editora salvar(@RequestBody Editora editora) {
		
		return repository.save(editora);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@RequestParam Long id) {
		repository.deleteById(id);
	}
	

}
