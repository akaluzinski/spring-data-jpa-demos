package eu.kaluzinski.sdjpaintro;

import eu.kaluzinski.sdjpaintro.domain.Book;
import eu.kaluzinski.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldAddBooksToRepository() {
        assertThat(bookRepository.count()).isEqualTo(0L);
        final List<Book> books = Arrays.asList(
                new Book("Some test book", "3490098", "222"),
                new Book("Some nother test book", "34900918", "222")
        );
        bookRepository.saveAll(books);
        assertThat(bookRepository.count()).isEqualTo(2L);
    }
}
