package livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
