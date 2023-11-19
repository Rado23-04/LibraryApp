package Modal;

import java.util.Objects;

public class Book {
    public enum Topic {
        COMEDY, ROMANCE, OTHER
    }
    private int book_id;
    private String title;
    private Topic topic;
    private int publication_year;

    public Book(int book_id, String title, Topic topic, int publication_year) {
        this.book_id = book_id;
        this.title = title;
        this.topic = topic;
        this.publication_year = publication_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id && publication_year == book.publication_year && Objects.equals(title, book.title) && topic == book.topic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, title, topic, publication_year);
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }
}
