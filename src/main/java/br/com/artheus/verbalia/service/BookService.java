package br.com.artheus.verbalia.service;

import br.com.artheus.verbalia.dto.ApiBook;
import br.com.artheus.verbalia.dto.ApiResponse;
import br.com.artheus.verbalia.exceptions.BookNotFoundException;
import br.com.artheus.verbalia.model.Author;
import br.com.artheus.verbalia.model.Book;
import br.com.artheus.verbalia.repository.AuthorRepository;
import br.com.artheus.verbalia.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findBookByTitleFromApi(String title) {
        String url = "https://gutendex.com/books?search=" + title;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);

        List<ApiBook> results = response.getBody().getResults();
        if (results.isEmpty()) {
            throw new BookNotFoundException(title);
        }

        ApiBook apiBook = results.get(0);
        String authorName = apiBook.getAuthorName();

        Author author = authorRepository.findByName(authorName)
                .orElseGet(() -> {
                    Author newAuthor = new Author(
                            authorName,
                            apiBook.getAuthorBirthYear(),
                            apiBook.getAuthorDeathYear()
                    );
                    return authorRepository.save(newAuthor);
                });



        List<Book> existingBooks = bookRepository.findByTitleAndAuthorName(apiBook.getTitle(), authorName);
        if (!existingBooks.isEmpty()) {
            return existingBooks.get(0);
        }

        Book book = new Book();
        book.setTitle(apiBook.getTitle());
        book.setLanguage(apiBook.getLanguage());
        book.setDownloads(Long.valueOf(apiBook.getDownloadCount()));
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public List<Book> findByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}
