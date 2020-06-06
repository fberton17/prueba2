import com.opencsv.CSVReader;
import java.lang.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS - INICIO **************************
        try {
            System.out.println("lpm");
            String archCSV = "Data/books.csv";
            CSVReader csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;
            while ((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0] + " | " + fila[1]  + " |  " + fila[2]);
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("lpm");

    }
}
