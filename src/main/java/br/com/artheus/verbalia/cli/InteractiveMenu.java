package br.com.artheus.verbalia.cli;

import br.com.artheus.verbalia.exceptions.BookNotFoundException;
import br.com.artheus.verbalia.model.Author;
import br.com.artheus.verbalia.model.Book;
import br.com.artheus.verbalia.repository.AuthorRepository;
import br.com.artheus.verbalia.service.BookService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class InteractiveMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;
    private final AuthorRepository authorRepository;

    public InteractiveMenu(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("*********************");
            System.out.println("***** Main Menu *****");
            System.out.println("*********************");
            System.out.println("* 1. - Find Book by Title (API + DB)  *");
            System.out.println("* 2. - List Registered Books          *");
            System.out.println("* 3. - List Authors                   *");
            System.out.println("* 4. - List Authors Alive In Year     *");
            System.out.println("* 5. - List Books By Language         *");
            System.out.println("* 6. - Exit                           *");
            System.out.println("*********************");
            System.out.print("Enter option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    findBookByTitle();
                    break;
                case 2:
                    listAllBooks();
                    break;
                case 3:
                    listAllAuthors();
                    break;
                case 4:
                    listAuthorsAliveInYear();
                    break;
                case 5:
                    listBooksByLanguage();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting. Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void findBookByTitle() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        try {
            Book book = bookService.findBookByTitleFromApi(title);
            System.out.println("Book found and saved:");
            System.out.println(book);
        } catch (BookNotFoundException e) {
            System.out.println("Book not found in API: " + title);
        }
    }

    private void listAllBooks() {
        List<Book> books = bookService.findAll();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Books registered:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void listAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            System.out.println("No authors found.");
        } else {
            System.out.println("Authors registered:");
            for (Author author : authors) {
                System.out.println(author);
            }
        }
    }

    private void listAuthorsAliveInYear() {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        List<Author> authors = authorRepository.findAuthorsAliveInYear(year);
        if (authors.isEmpty()) {
            System.out.println("No authors alive in year " + year);
        } else {
            System.out.println("Authors alive in year " + year + ":");
            for (Author author : authors) {
                System.out.println(author);
            }
        }
    }

    private void listBooksByLanguage() {
        System.out.println("Choose language code:");
        System.out.println("1 - PT (Portuguese)");
        System.out.println("2 - EN (English)");
        System.out.println("3 - ES (Spanish)");
        System.out.println("4 - FR (French)");
        System.out.print("Enter option: ");

        int langOption = Integer.parseInt(scanner.nextLine());
        String langCode = switch (langOption) {
            case 1 -> "pt";
            case 2 -> "en";
            case 3 -> "es";
            case 4 -> "fr";
            default -> "";
        };

        if (langCode.isEmpty()) {
            System.out.println("Invalid language option.");
            return;
        }

        List<Book> books = bookService.findByLanguage(langCode);
        if (books.isEmpty()) {
            System.out.println("No books found for language: " + langCode);
        } else {
            System.out.println("Books in language " + langCode + ":");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
