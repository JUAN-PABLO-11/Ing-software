package miproyecto.prueba.service;

import miproyecto.prueba.model.Rating;
import miproyecto.prueba.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    private final AtomicLong idCounter = new AtomicLong(1);

    // Requisito 3: calificar de 1 a 5, sin validar compra
    public Rating rateBook(Long bookId, String username, int score) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("La calificación debe ser entre 1 y 5");
        }
        Rating rating = new Rating(idCounter.getAndIncrement(), bookId, username, score);
        return ratingRepository.save(rating);
    }
}