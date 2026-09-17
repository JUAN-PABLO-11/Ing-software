package miproyecto.prueba.model;

public class Rating {
    private Long id;
    private Long bookId;
    private String username;
    private int score; // 1 a 5

    public Rating(Long id, Long bookId, String username, int score) {
        this.id = id;
        this.bookId = bookId;
        this.username = username;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}