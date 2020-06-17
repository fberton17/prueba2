package Consultas;

import Clases.Book;
import Clases.Rating;
import Clases.User;
import Heap.HeapImpl;
import Heap.HeapSizeOverflow;
import Heap.MaxHeap;
import LinkedList.Lista;

public class Consulta2 implements Comparable {
    public int cantidad;
    public Book book;

    private Consulta2(Book book) {
        this.book = book;
        this.cantidad = 1;
    }

    private void addCantidad() {
        this.cantidad += 1;
    }

    public static void startConsulta2(User[] users_array) throws HeapSizeOverflow {
        long start = 0, stop = 0;
        start = System.currentTimeMillis();
        Consulta2[] array_con2 = new Consulta2[10001];
        Book libro;
        Lista lista;
        Consulta2 datoConsulta;
        Object[] ratings;
        int j;
        for (User usuario : users_array) {
            lista = usuario.getRatings();
            j = 0;
            ratings = lista.toArray();
            for(Object rating: ratings){
                libro =((Rating) rating).getBook();
                if(array_con2[((int)libro.getBook_id())-1] == null) {
                    datoConsulta = new Consulta2(libro);
                    array_con2[((int)libro.getBook_id())-1] = datoConsulta;
                }else{
                    array_con2[((int)libro.getBook_id())-1].addCantidad();
                }
            }

        }
        MaxHeap<Consulta2> heap = new HeapImpl(10000);
        for (Consulta2 dato : array_con2) {
            if(dato != null) {
                heap.insert(dato);
            }
        }
        Consulta2 top;
        for (int e = 0; e <= 19; e++) {        // imprime en orden
            top = heap.getMax();
            System.out.println(" Id del libo:" + top.book.getBook_id() +
                    "\n Título:" + top.book.getTitle() +
                    "\n Cantidad:" + top.cantidad + "\n");
            heap.deleteMax();
        }
        stop = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución deconsulta: " + (stop - start) + "ms");


        }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Consulta2) {
            return this.cantidad - ((Consulta2) o).cantidad;
        } else {
            return -1;
        }
    }
}
