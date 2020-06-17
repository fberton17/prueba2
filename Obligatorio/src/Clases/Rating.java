package Clases;

public class Rating {
    private int rating;
    private Book book;

    public Rating(int rating, Book book) {
        this.rating = rating;
        this.book = book;
    }

    public int getRating() {
        return rating;
    }

    public Book getBook() {
        return book;
    }
}
