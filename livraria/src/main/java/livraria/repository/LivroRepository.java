package livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	@Query("select l from Livro l "
			+ " where upper(l.titulo) like upper(:titulo) or l.autor.id = :autor "
			+ " or  l.editora.id = :editora  or l.estilo.id = :estilo")
	
	List<Livro> findByTituloAutorEstiloEditora(
			@Param("titulo") String titulo,
			@Param("autor") Long id_autor,
			@Param("editora") Long id_editora,
			@Param("estilo") Long id_estilo);
	
	@Query("select l from Livro l where upper(l.titulo) like upper(:titulo) ")
	List<Livro> findByTitulo(
			@Param("titulo") String titulo
			);

}
