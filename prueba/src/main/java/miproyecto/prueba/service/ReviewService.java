package miproyecto.prueba.service;

import miproyecto.prueba.model.Review;
import miproyecto.prueba.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    private final AtomicLong idCounter = new AtomicLong(1);

    // Requisito 4a: solo arma el objeto, no lo guarda (esto es el "preview")
    public Review preview(Long bookId, String username, String content) {
        return new Review(null, bookId, username, content);
    }

    // Requisito 4b: esto sí guarda, cuando el usuario confirma
    public Review submit(Long bookId, String username, String content) {
        Review review = new Review(idCounter.getAndIncrement(), bookId, username, content);
        return reviewRepository.save(review);
    }
}