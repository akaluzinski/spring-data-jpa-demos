package eu.kaluzinski.sdjpaintro.bootstrap;

import eu.kaluzinski.sdjpaintro.domain.Book;
import eu.kaluzinski.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Book book1 = new Book("Data Driven Design", "3213", "Somepublished");
        Book savedBook = bookRepository.save(book1);

        Book book2 = new Book("Spring in action", "3333", "SomeAnotherPublisher");
        Book savedBook2 = bookRepository.save(book2);

        bookRepository.findAll().forEach(book -> {
            System.out.println(book);
        });
    }
}
