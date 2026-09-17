package miproyecto.prueba.repository;

import miproyecto.prueba.model.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingRepository {

    private final List<Rating> ratings = new ArrayList<>();

    public Rating save(Rating rating) {
        ratings.add(rating);
        return rating;
    }

    public List<Rating> findAll() {
        return ratings;
    }

    public List<Rating> findByBookId(Long bookId) {
        return ratings.stream()
                .filter(r -> r.getBookId().equals(bookId))
                .toList();
    }
}