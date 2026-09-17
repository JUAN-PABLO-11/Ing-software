package miproyecto.prueba.repository;

import miproyecto.prueba.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewRepository {

    private final List<Review> reviews = new ArrayList<>();

    public Review save(Review review) {
        reviews.add(review);
        return review;
    }

    public List<Review> findAll() {
        return reviews;
    }

    public List<Review> findByBookId(Long bookId) {
        return reviews.stream()
                .filter(r -> r.getBookId().equals(bookId))
                .toList();
    }
}