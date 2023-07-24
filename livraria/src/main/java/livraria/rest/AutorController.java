package livraria.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import livraria.model.Autor;
import livraria.repository.AutorRepository;

@RestController
@RequestMapping("/autor")

public class AutorController {
	
	private final AutorRepository repository;
	
	@Autowired
	public AutorController( AutorRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Autor> listAutors(){
		
		return repository.findAll(); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor salvar(@RequestBody Autor autor) {
		
		return repository.save(autor);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@RequestParam Long id) {
		repository.deleteById(id);
	}
	

}
