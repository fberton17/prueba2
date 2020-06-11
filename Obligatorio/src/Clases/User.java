package Clases;

import LinkedList.Lista;
import LinkedList.ListaEnlazada;

import java.awt.*;

public class User {
    private long user_id;
    private Lista ratings; //NO TIENE PQ SER UNA LISTa
    private Lista reserverd_to_read;

    public User(long id) {
        this.user_id = id;
        this.ratings = new ListaEnlazada();
        this.reserverd_to_read = new ListaEnlazada();
    }
    public void addRead(Book book){
        this.reserverd_to_read.add(book);
    }
    public void addRating(Rating rating){
        this.ratings.add(rating);
    }
}
