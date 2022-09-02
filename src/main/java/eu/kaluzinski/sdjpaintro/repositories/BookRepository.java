package eu.kaluzinski.sdjpaintro.repositories;

import eu.kaluzinski.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
