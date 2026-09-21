package miproyecto.prueba.repository;

import miproyecto.prueba.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Spring genera la consulta automáticamente a partir del nombre del método
    List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(String author, String title);

    List<Book> findByIsbn(String isbn);
}