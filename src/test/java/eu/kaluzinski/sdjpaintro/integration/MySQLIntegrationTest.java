package eu.kaluzinski.sdjpaintro.integration;

import eu.kaluzinski.sdjpaintro.configuration.RunProfile;
import eu.kaluzinski.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles(RunProfile.LOCAL)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackageClasses = { eu.kaluzinski.sdjpaintro.bootstrap.DataInitializer.class })
public class MySQLIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldConnectToMySQLDatabase() {
        assertThat(bookRepository.count()).isEqualTo(2L);
    }


}
