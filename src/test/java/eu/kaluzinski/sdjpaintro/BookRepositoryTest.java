package eu.kaluzinski.sdjpaintro;

import eu.kaluzinski.sdjpaintro.configuration.RunProfile;
import eu.kaluzinski.sdjpaintro.domain.Book;
import eu.kaluzinski.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Profile({ RunProfile.LOCAL, RunProfile.DEFAULT })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackageClasses = { eu.kaluzinski.sdjpaintro.bootstrap.DataInitializer.class })
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldRunBootstrap() {
        assertThat(bookRepository.count()).isEqualTo(2L);
    }

    @Test
    void shouldAddBooksToRepository() {
        assertThat(bookRepository.count()).isEqualTo(2L);
        final List<Book> books = Arrays.asList(
                new Book("Some test book", "3490098", "222", null),
                new Book("Some nother test book", "34900918", "222", null)
        );
        bookRepository.saveAll(books);
        assertThat(bookRepository.count()).isEqualTo(4L);
    }
}
