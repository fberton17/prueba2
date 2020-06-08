package Main;

import com.opencsv.CSVReader;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS - INICIO **************************
        try {
            String archCSV = "Data/books.csv";
            CSVReader csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;
            while ((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
            }
            csvReader.close();
            csvReader = null;

            archCSV = "Data/ratings.csv";
            CSVReader csvReader2 = new CSVReader(new FileReader(archCSV));
            while ((fila = csvReader2.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
            }
            csvReader2.close();
            csvReader2 = null;

            archCSV = "Data/to_read.csv";
            CSVReader csvReader3 = new CSVReader(new FileReader(archCSV));
            while ((fila = csvReader3.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]);
            }
            csvReader3.close();
            csvReader3 = null;


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
