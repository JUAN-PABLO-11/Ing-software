package miproyecto.prueba.service;

import miproyecto.prueba.model.Book;
import miproyecto.prueba.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Requisito 1: búsqueda simple (autor O título)
    public List<Book> simpleSearch(String query) {
        String q = query.toLowerCase();
        return bookRepository.findAll().stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(q)
                        || b.getTitle().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    // Requisito 2: búsqueda avanzada (cualquier combinación de campos)
    public List<Book> advancedSearch(String author, String title, String isbn) {
        return bookRepository.findAll().stream()
                .filter(b -> author == null || author.isBlank()
                        || b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .filter(b -> title == null || title.isBlank()
                        || b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(b -> isbn == null || isbn.isBlank()
                        || b.getIsbn().equals(isbn))
                .collect(Collectors.toList());
    }
}