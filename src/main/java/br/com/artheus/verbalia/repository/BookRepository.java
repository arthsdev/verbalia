package br.com.artheus.verbalia.repository;

import br.com.artheus.verbalia.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
