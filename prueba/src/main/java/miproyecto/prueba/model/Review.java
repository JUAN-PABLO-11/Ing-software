package miproyecto.prueba.model;

public class Review {
    private Long id;
    private Long bookId;
    private String username;
    private String content;

    public Review(Long id, Long bookId, String username, String content) {
        this.id = id;
        this.bookId = bookId;
        this.username = username;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}