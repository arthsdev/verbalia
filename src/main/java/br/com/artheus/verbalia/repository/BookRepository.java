package br.com.artheus.verbalia.repository;

import br.com.artheus.verbalia.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.author.name = :authorName")
    List<Book> findByTitleAndAuthorName(String title, String authorName);

    List<Book> findByLanguage(String language);
}
