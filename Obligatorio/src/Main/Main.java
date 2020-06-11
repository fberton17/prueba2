package Main;

import Clases.Author;
import Clases.Book;
import Clases.Rating;
import Clases.User;
import com.opencsv.CSVReader;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        int entrada;

        System.out.println("Seleccione la opción que desee:");
        System.out.println("  1. Carga de datos");
        System.out.println("  2. Ejecutar consultas");
        System.out.println("  3. Salir");

        entrada = entradaEscaner.nextInt(); //Invocamos un método sobre un objeto Scanner

        if (entrada == 1){
            // CARGA DE DATOS - INICIO *************************************************************************************
            try {
                long start = 0, stop = 0;
                start = System.currentTimeMillis();

                String archCSV = "Obligatorio/Data/books.csv";
               CSVReader csvReader = new CSVReader(new FileReader(archCSV));
                String[] fila = csvReader.readNext();

                Book[] books_array = new Book[10001];
                String[] autores;
                int year;
                long id;
                int pos;
                while ((fila = csvReader.readNext()) != null) {
                    // FIXME ver si la separaciones de autor está bien
                    id = Long.parseLong(fila[0]);
                    try{year = Integer.parseInt(fila[3]);
                    }catch (Exception e){ year = 40000;} // Si el año es NaN se pone en 40000
                    Book libro = new Book(id,fila[1],year,fila[4],fila[5],fila[6],fila[7]);
                    autores = fila[2].split(",");
                    for (int j = 0; j != autores.length; j++) {
                        Author autor = new Author(autores[j]);
                        libro.addAuthor(autor);
                    }
                    books_array[((int)id)-1]= libro;
                }
                csvReader.close();


                archCSV = "Obligatorio/Data/to_read.csv";
                CSVReader csvReader3 = new CSVReader(new FileReader(archCSV));
                fila = csvReader3.readNext();

                int book_id;
                User[] users_array = new User[53425];
                Book libro;
                while ((fila = csvReader3.readNext()) != null) { //FIXME NO AGREGA TODOS LOS USUARIOS
                    id = Long.parseLong(fila[0]);
                    book_id = (Integer.parseInt(fila[1]) ) - 1;
                    User usuario = new User(id);
                    libro = books_array[book_id];
                    usuario.addRead(libro);
                    users_array[((int)id) -1] = usuario;
                }
                csvReader3.close();
                csvReader3 = null;


                archCSV = "Obligatorio/Data/ratings.csv";
                CSVReader csvReader2 = new CSVReader(new FileReader(archCSV));
                fila = csvReader2.readNext();

                int rate;
                int user_id;
                User usuario;
                while ((fila = csvReader2.readNext()) != null) {
                    System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
                    user_id = Integer.parseInt(fila[0]) - 1;
                    book_id = Integer.parseInt(fila[1]) - 1;
                    rate = Integer.parseInt(fila[2]);

                    libro = books_array[book_id];
                    usuario = users_array[user_id];
                    Rating rating = new Rating(rate,libro);
                    usuario.addRating(rating);
                }
                csvReader2.close();
                csvReader2 = null;

                stop = System.currentTimeMillis();

                System.out.println("Tiempo de carga de datos: " + (stop - start) + "ms");


            } catch (Exception e) {
                System.out.println(e);
            }

        }else if (entrada == 2){
            // CONSULTAS
            System.out.println("1. Indicar el Top 10 de libros que más lecturas tienen por parte de usuarios");
            System.out.println("2. Indicar el Top 20 de libros que más cantidaad de lecturas tienen");
            System.out.println("3. Indicar el Top 10 de usuarios que realizaron mayor cantidad de\n" +
                    "   evaluaciones a libros y ordenarlo por rating promedio descendente");
            System.out.println("4. Indicar el Top 5 de los idiomas asociados a libros que han tenido más reservas.");
            System.out.println("5. Indicar el Top 20 de autores que más publicaciones han hecho por año");
            System.out.println("6. Salir");

            entrada = entradaEscaner.nextInt();


        }else if (entrada == 3){
            System.out.println("Programa finalizado");
            System.exit(0);
        }
    }
}
