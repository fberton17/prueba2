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

    public Consulta4(Idioma idioma) {
        this.idioma = idioma;
        this.cantidadreservas = 1;
    }

    private void addCantidad() {
        this.cantidadreservas += 1;
    }

    public static void startConsulta4(Book[] books_array, User[] users_array) throws HeapSizeOverflow {
        long start = 0, stop = 0;
        start = System.currentTimeMillis();
        Consulta4[] array_con4 = new Consulta4[10001];
        Book libro;
        Lista lista;
        ListaDobleEnlazada idiomas = new ListaDobleEnlazada(); // FIXME hacer que sea solo enlazada a ver si anda el heap
        Consulta4 datoConsulta;
        int j;
        for (int i = 0; i < 10001; i++) {
            for (User usuario : users_array) {
                lista = usuario.getReserverd_to_read();
                j = 0;
                while (lista.get(j) != null) { //FIXME Cuando .get retorna null se pudre todo
                    libro = (Book) lista.get(j); //FIXME IMPLEMENTAR OPERADOR DIAMANTE EN LINKED LIST
                    String idiomatemp = libro.getLanguage_code();
                    Idioma esteidioma = new Idioma(idiomatemp);
                    datoConsulta = new Consulta4(esteidioma);

                    if (idiomas.primero == null) {
                        idiomas.add(esteidioma);
                        array_con4[i] = datoConsulta;
                        i++;
                    } else {
                        idiomas.add(esteidioma);
                        if (esteidioma.equals(idiomas.ultimo.getAnterior())) {
                            idiomas.ultimo = null;
                            esteidioma.addCantidad();
                        } else {
                            idiomas.add(esteidioma);
                            System.out.println(esteidioma);
                        }

                    }
                    j++;
                }
            }
        }


           /* MaxHeap<Idioma> heap = new HeapImpl(10000);
            for (Idioma dato : idiomas) {
                heap.insert(dato);
            }
            Idioma top;
            for (int e = 0; e <= 4; e++) {        // imprime en orden
                top = heap.getMax();
                System.out.println("\n Idioma:" + top.idioma + "\n Cantidad:" + top.cantidadreservas + "\n");
                heap.deleteMax();
            }
            stop = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución deconsulta: " + (stop - start) + "ms");
*/
        }
    }



