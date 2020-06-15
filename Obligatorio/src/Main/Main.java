package Main;

import Clases.Author;
import Clases.Book;
import Clases.Rating;
import Clases.User;
import Heap.HeapSizeOverflow;
import com.opencsv.CSVReader;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

import Consultas.*;


import static Consultas.Consulta1.startConsulta1;
import static Consultas.Consulta3.startConsulta3;


public class Main {

    public static void main(String[] args) throws HeapSizeOverflow {

        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        int entrada;
        boolean carga = false;
        User[] users_array = new User[53424];
        Book[] books_array = new Book[10000];

        while (true) {
            System.out.println("Seleccione la opción que desee:");
            System.out.println("  1. Carga de datos");
            System.out.println("  2. Ejecutar consultas");
            System.out.println("  3. Salir");

            entrada = entradaEscaner.nextInt(); //Invocamos un método sobre un objeto Scanner

            if (entrada == 1) {
                // CARGA DE DATOS - INICIO
                try {
                    long start = 0, stop = 0;
                    start = System.currentTimeMillis();

                    String archCSV = "Obligatorio/Data/books.csv";
                    CSVReader csvReader = new CSVReader(new FileReader(archCSV));
                    String[] fila = csvReader.readNext();

                    String[] autores;
                    int year;
                    long id;
                    while ((fila = csvReader.readNext()) != null) {
                        // FIXME ver si la separaciones de autor está bien
                        id = Long.parseLong(fila[0]);
                        try {
                            year = Integer.parseInt(fila[3]);
                        } catch (Exception e) {
                            year = 40000;
                        } // Si el año es NaN se pone en 40000
                        Book libro = new Book(id, fila[1], year, fila[4], fila[5], fila[6], fila[7]);
                        autores = fila[2].split(",");
                        for (int j = 0; j != autores.length; j++) {
                            Author autor = new Author(autores[j]);
                            libro.addAuthor(autor);
                        }
                        books_array[((int) id) - 1] = libro;
                    }
                    csvReader.close();


                    archCSV = "Obligatorio/Data/to_read.csv";
                    CSVReader csvReader3 = new CSVReader(new FileReader(archCSV));
                    fila = csvReader3.readNext();

                    int book_id;
                    Book libro;
                    User usuario;
                    while ((fila = csvReader3.readNext()) != null) { //FIXME NO AGREGA TODOS LOS USUARIOS
                        id = Long.parseLong(fila[0]);
                        book_id = (Integer.parseInt(fila[1])) - 1;
                        if (users_array[((int) id) - 1] == null) {
                            usuario = new User(id);
                            users_array[((int) id) - 1] = usuario;
                        } else {
                            usuario = users_array[((int) id) - 1];
                        }
                        libro = books_array[book_id];
                        usuario.addRead(libro);

                    }
                    csvReader3.close();


                    archCSV = "Obligatorio/Data/ratings.csv";
                    CSVReader csvReader2 = new CSVReader(new FileReader(archCSV));
                    fila = csvReader2.readNext();

                    int rate;
                    int user_id;
                    while ((fila = csvReader2.readNext()) != null) {
                        user_id = Integer.parseInt(fila[0]) - 1;
                        book_id = Integer.parseInt(fila[1]) - 1;
                        rate = Integer.parseInt(fila[2]);

                        libro = books_array[book_id];
                        if (users_array[user_id] == null) {          // Consideramos caso en el que un user no esté en to_read
                            usuario = new User((long) (user_id + 1));
                            users_array[user_id] = usuario;
                        } else {
                            usuario = users_array[user_id];
                        }
                        Rating rating = new Rating(rate, libro);
                        usuario.addRating(rating);
                    }
                    csvReader2.close();

                    stop = System.currentTimeMillis();

                    System.out.println("Tiempo de carga de datos: " + (stop - start) + "ms");
                    carga = true;

                } catch (Exception e) {
                    System.out.println(e);
                }                               // FINAL CARGA DE DATOS

            } if (entrada == 2 && carga) {
                // CONSULTAS
                System.out.println("1. Indicar el Top 10 de libros que más lecturas tienen por parte de usuarios");
                System.out.println("2. Indicar el Top 20 de libros que más cantidaad de lecturas tienen");
                System.out.println("3. Indicar el Top 10 de usuarios que realizaron mayor cantidad de\n" +
                        "   evaluaciones a libros y ordenarlo por rating promedio descendente");
                System.out.println("4. Indicar el Top 5 de los idiomas asociados a libros que han tenido más reservas.");
                System.out.println("5. Indicar el Top 20 de autores que más publicaciones han hecho por año");
                System.out.println("6. Salir");

                entrada = entradaEscaner.nextInt();

                switch (entrada) {
                    case 1:
                        startConsulta1(books_array,users_array);
                        break;
                    case 2:

                        break;
                    case 3:
                        startConsulta3(users_array);
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        System.out.println("Programa finalizado");
                        System.exit(0);
                    default:
                        System.out.println("Ingrese una opción válida");
                }

            } else if (entrada == 3) {
                System.out.println("Programa finalizado");
                System.exit(0);
            }
        }
    }
}
