package br.com.artheus.verbalia.repository;

import br.com.artheus.verbalia.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
