package miproyecto.prueba.repository;

import miproyecto.prueba.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1L, "Clean Code", "Robert Martin", "9780132350884"));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", "9780134685991"));
        books.add(new Book(3L, "Spring in Action", "Craig Walls", "9781617294945"));
    }

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}