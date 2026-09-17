package miproyecto.prueba.controller;

import miproyecto.prueba.model.Book;
import miproyecto.prueba.model.Rating;
import miproyecto.prueba.model.Review;
import miproyecto.prueba.service.BookService;
import miproyecto.prueba.service.RatingService;
import miproyecto.prueba.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/search")
    public List<Book> simpleSearch(@RequestParam String q) {
        return bookService.simpleSearch(q);
    }

    @GetMapping("/advanced-search")
    public List<Book> advancedSearch(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn) {
        return bookService.advancedSearch(author, title, isbn);
    }

    @PostMapping("/{bookId}/ratings")
    public Rating rate(@PathVariable Long bookId,
            @RequestParam String username,
            @RequestParam int score) {
        return ratingService.rateBook(bookId, username, score);
    }

    @PostMapping("/{bookId}/reviews/preview")
    public Review previewReview(@PathVariable Long bookId,
            @RequestParam String username,
            @RequestParam String content) {
        return reviewService.preview(bookId, username, content);
    }

    @PostMapping("/{bookId}/reviews")
    public Review submitReview(@PathVariable Long bookId,
            @RequestParam String username,
            @RequestParam String content) {
        return reviewService.submit(bookId, username, content);
    }
}