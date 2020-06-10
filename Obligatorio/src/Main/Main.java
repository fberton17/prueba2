package Main;

import com.opencsv.CSVReader;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS - INICIO *************************************************************************************
        /*try {
            String archCSV = "Obligatorio/Data/books.csv";
            CSVReader csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;
            while ((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
            }
            csvReader.close();
            csvReader = null;

            archCSV = "Obligatorio/Data/ratings.csv";
            CSVReader csvReader2 = new CSVReader(new FileReader(archCSV));
            while ((fila = csvReader2.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
            }
            csvReader2.close();
            csvReader2 = null;

            archCSV = "Obligatorio/Data/to_read.csv";
            CSVReader csvReader3 = new CSVReader(new FileReader(archCSV));
            while ((fila = csvReader3.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]);
            }
            csvReader3.close();
            csvReader3 = null;


        } catch (Exception e) {
            System.out.println(e);
        }*/
        //FIXME falta agregar datos a tads, sin printearlos
// FINALIZA CARGA DE DATOS**********************************************************************************************

// FIXME menú aquí abajo ===============================================================================================
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
                String archCSV = "Obligatorio/Data/books.csv";
                CSVReader csvReader = new CSVReader(new FileReader(archCSV));
                String[] fila = null;
                while ((fila = csvReader.readNext()) != null) {
                    System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
                }
                csvReader.close();
                csvReader = null;

                archCSV = "Obligatorio/Data/ratings.csv";
                CSVReader csvReader2 = new CSVReader(new FileReader(archCSV));
                while ((fila = csvReader2.readNext()) != null) {
                    System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
                }
                csvReader2.close();
                csvReader2 = null;

                archCSV = "Obligatorio/Data/to_read.csv";
                CSVReader csvReader3 = new CSVReader(new FileReader(archCSV));
                while ((fila = csvReader3.readNext()) != null) {
                    System.out.println(fila[0] + " | " + fila[1]);
                }
                csvReader3.close();
                csvReader3 = null;


            } catch (Exception e) {
                System.out.println(e);
            }
            //FIXME falta agregar datos a tads, sin printearlos

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
