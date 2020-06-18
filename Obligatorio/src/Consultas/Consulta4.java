package Consultas;

import Clases.Book;
import Clases.BubbleSort;
import Clases.Idioma;
import Clases.User;
import Heap.HeapImpl;
import Heap.HeapSizeOverflow;
import Heap.MaxHeap;
import LinkedList.Lista;
import LinkedList.ListaDobleEnlazada;


public class Consulta4 implements Comparable<Idioma> {

    public int cantidadreservas;
    public Book book;
    public Idioma idioma;

    public Consulta4(Idioma idioma) throws HeapSizeOverflow {
        this.idioma = idioma;
        this.cantidadreservas = 1;
    }

    @Override
    public int compareTo(Idioma o) {
        if (cantidadreservas < o.cantidadreservas) {
            return -1;
        }
        if (cantidadreservas > o.cantidadreservas) {
            return 1;
        }
        return 0;
    }

    private static void bubbleSort(Idioma arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j].getCantidadreservas() < arr[j + 1].getCantidadreservas()) {
                        // swap temp and arr[i]
                        Idioma temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

    static void imprimeArrayidiomcant(Idioma[] array) {
        for (int i = 0; i < array.length; i++) {
            while (array[i + 1].getIdioma() != null) {
                System.out.println((i + 1) + ". " + array[i + 1].getIdioma() + " - Cantidad: " + array[i + 1].getCantidadreservas());
            }
        }
    }

    public static void cargoidiomas(Book[] books_array, User[] users_array) {
        Lista leidos;
        Book libro;
        String[] idiomasleidos = new String[10001];
        Idioma[] idiomcant = new Idioma[10001];
        int j;
        for (User usuario : users_array) {
            leidos = usuario.getReserverd_to_read();
            j = 0;
            while (leidos.get(j) != null) { //FIXME Cuando .get retorna null se pudre todo
                libro = (Book) leidos.get(j);
                String idiomatemp = libro.getLanguage_code();
                long codigo = libro.getBook_id();
                idiomasleidos[(int) codigo] = idiomatemp;

                j++;
            }
        }

        for (int ind = 0; ind < (idiomasleidos.length - 1); ind++) {

            if (idiomasleidos[ind] != null) {

                idiomcant[ind] = new Idioma(idiomasleidos[ind]);
                idiomcant[ind].setCantidadreservas(1);

                for (int h = (ind + 1); h < (idiomasleidos.length); h++) {
                    //System.out.println("llegue 3");
                    //System.out.println(idiomasleidos[h]);
                    //System.out.println(idiomasleidos[ind]);
                    if (idiomasleidos[h] != null) {
                        //System.out.println("llegue 4");

                        if (idiomasleidos[h].equals(idiomasleidos[ind])) { //FIXME no entra aca
                            //System.out.println("encontre uno igual");
                            idiomcant[ind].cantidadreservas++;
                            idiomasleidos[h] = null;
                            //System.out.println(idiomasleidos[h]);
                            //System.out.println("sume uno a la cantidad");
                            //System.out.println(idiomcant[ind].getIdioma());
                            //System.out.println(idiomcant[ind].getCantidadreservas());
                        }
                    }
                }
            }
            bubbleSort(idiomcant);
            imprimeArrayidiomcant(idiomcant);
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