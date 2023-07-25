package livraria.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import livraria.model.Estilo;
import livraria.repository.EstiloRepository;

@RestController
@RequestMapping("/estilo")
public class EstiloController {
	
	private EstiloRepository repository;
	
	public EstiloController(EstiloRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Estilo> listaEstilo(){
		return repository.findAll();
	}
	
	@GetMapping(value = "editar")
	public Estilo buscarPorId(@RequestParam Long id) {
		Optional<Estilo> estilo = repository.findById(id);
		
		Estilo objeto = estilo.get();
		
		return objeto;	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estilo salvar(@RequestBody Estilo estilo) {
		return repository.save(estilo);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@RequestParam Long id) {
		repository.deleteById(id);
	}

}
