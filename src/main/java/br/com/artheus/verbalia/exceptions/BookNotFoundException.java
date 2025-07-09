package br.com.artheus.verbalia.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book with ID : " + id  + " not found");
    }
}
