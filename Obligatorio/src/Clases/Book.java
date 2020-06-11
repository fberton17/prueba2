package Clases;

import LinkedList.Lista;
import LinkedList.ListaEnlazada;

public class Book {
    private long book_id;
    public Lista authors; //FIXME PONER LINKED LIST
    private String isbn;
    private int original_publication_year;
    private String original_title;
    private String title;
    private String language_code;
    private String image_url;


    public Book(long book_id, String isbn, int original_publication_year, String original_title,
                String title, String language_code, String image_url) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.original_publication_year = original_publication_year;
        this.original_title = original_title;
        this.title = title;
        this.language_code = language_code;
        this.image_url = image_url;
        authors = new ListaEnlazada();
    }
    public void addAuthor(Author autor){
        authors.add(autor);
    }
}
