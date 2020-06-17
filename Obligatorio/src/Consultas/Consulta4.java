package Consultas;

import Clases.Book;
import Clases.Idioma;
import Clases.User;
import Heap.HeapImpl;
import Heap.HeapSizeOverflow;
import Heap.MaxHeap;
import LinkedList.Lista;
import LinkedList.ListaDobleEnlazada;
import LinkedList.ListaEnlazada;

public class Consulta4 {

    public int cantidadreservas;
    public Book book;
    public Idioma idioma;
    public int codigoidioma;

    public Consulta4(Idioma idioma) throws HeapSizeOverflow {
        this.idioma = idioma;
        this.cantidadreservas = 1;
    }

    public static void cargoidiomas(Book[] books_array, User[] users_array) {
        Lista leidos;
        Book libro;
        Idioma[] idiomasleidos = new Idioma[10001];
        Idioma[] idiomcant = new Idioma[10001];
        int j;
        for (User usuario : users_array) {
            leidos = usuario.getReserverd_to_read();
            j = 0;
            while (leidos.get(j) != null) { //FIXME Cuando .get retorna null se pudre todo
                libro = (Book) leidos.get(j);
                String idiomatemp = libro.getLanguage_code();
                Idioma esteidioma = new Idioma(idiomatemp);
                for (int i = 1; i < idiomasleidos.length; i++) {
                    idiomasleidos[i] = esteidioma;
                }
                j++;
            }
        }
        System.out.println("Entrando al for");
        for (int ind = 1; ind < idiomasleidos.length; ind++) {
            if (idiomasleidos[ind].idioma != "no") {
                idiomasleidos[ind] = idiomcant[ind];
                System.out.println("Adentro del if");
                for (int h = (ind + 1); h < idiomasleidos.length; h++) {
                    if (idiomasleidos[h].idioma == idiomasleidos[ind].idioma) { //FIXME me da un NullPointer Exception y no entiendo porque
                        idiomcant[ind].cantidadreservas++;
                        idiomasleidos[h].idioma = "no";
                    }
                }
            }
        }


        MaxHeap<Idioma> heap = new HeapImpl(10000);
        for (Idioma dato : idiomcant){
            try {
                heap.insert(dato);
            } catch (HeapSizeOverflow heapSizeOverflow) {
                heapSizeOverflow.printStackTrace();
            }
        }
        Idioma top;
        for (int e = 0; e <= 4; e++) {        // imprime en orden
            top = heap.getMax();
            System.out.println("\n Idioma:" + top.idioma + "\n Cantidad:" + top.cantidadreservas + "\n");
            heap.deleteMax();
        }
    }

    public static void startConsulta4(Book[] books_array, User[] users_array) throws HeapSizeOverflow {
        long start = 0, stop = 0;
        start = System.currentTimeMillis();
        Book libro;
        Lista leidos;
        ListaDobleEnlazada idiomas = new ListaDobleEnlazada();
        Consulta4 datoConsulta;

        cargoidiomas(books_array, users_array);

        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución deconsulta: " + (stop - start) + "ms");
    }
}