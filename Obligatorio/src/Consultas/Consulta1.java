package Consultas;

import Clases.Book;
import Clases.User;
import Heap.HeapImpl;
import Heap.HeapSizeOverflow;
import Heap.MaxHeap;
import LinkedList.Lista;

public class Consulta1 implements Comparable{

    int cantidad;
    Book book;
    private Consulta1(Book book){
        this.book = book;
        this.cantidad = 1;
    }
    private void addCantidad(){
        this.cantidad += 1;
    }

    public static void startConsulta1(Book[] books_array, User[] users_array) throws HeapSizeOverflow {
        Consulta1[] array_con1 = new Consulta1[10001];
        Book libro;
        Lista lista;
        Consulta1 datoConsulta;
        int j;
        for(User usuario : users_array){
            lista = usuario.getReserverd_to_read();
             j = 0;
            while (lista.get(j) != null){ //FIXME Cuando .get retorna null se pudre todo
                libro = (Book) lista.get(j); //FIXME IMPLEMENTAR OPERADOR DIAMANTE EN LINKED LIST
                if(array_con1[((int)libro.getBook_id())-1] == null){
                    datoConsulta = new Consulta1(libro);
                    array_con1[((int)libro.getBook_id())-1] = datoConsulta;
                }else{
                    array_con1[((int)libro.getBook_id())-1].addCantidad();
                }
                j++;
            }
        }
        MaxHeap<Consulta1> heap = new HeapImpl(10000);
        for(Consulta1 dato : array_con1){
            heap.insert(dato);
        }
        for(int e = 0 ; e <= 7; e++){
            System.out.println(heap.getMax());
            heap.deleteMax();
        }


    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Consulta1){
            return this.cantidad - ((Consulta1) o).cantidad;
        } else{return -1;}

    }
}
