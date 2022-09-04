package eu.kaluzinski.sdjpaintro.bootstrap;

import eu.kaluzinski.sdjpaintro.configuration.RunProfile;
import eu.kaluzinski.sdjpaintro.domain.Book;
import eu.kaluzinski.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ RunProfile.LOCAL, RunProfile.DEFAULT })
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();
        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");

        System.out.println("Id: " + bookDDD.getId() );

        Book savedDDD = bookRepository.save(bookDDD);

        System.out.println("Id: " + savedDDD.getId() );

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

    }
}
