package Consultas;

import Clases.Rating;
import Clases.User;
import Heap.HeapImpl;
import Heap.HeapSizeOverflow;
import Heap.MaxHeap;
import LinkedList.Lista;

import java.awt.*;

public class Consulta3 implements Comparable{
    public User usuario;
    public int rate_count;
    public float average_rate;

    private Consulta3(User usuario, int rate_size){
        this.usuario = usuario;
        this.rate_count = rate_size;
    }

    private void setAvg(long avg){
        this.average_rate = avg;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Consulta3){
            return this.rate_count - ((Consulta3) o).rate_count;
        }else{
            return -1;
        }
    }

    private static void bubbleSortcon3(Consulta3[] arr) {
        int n = arr.length;
        Consulta3 temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].average_rate < arr[j].average_rate) {
                    //intercambiar
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static void startConsulta3(User[] users_array) throws HeapSizeOverflow {
        Lista rate_list;
        Consulta3 data_consulta;
        MaxHeap<Consulta3> heap = new HeapImpl<>(53424);
        long avg;
        for(User user: users_array){
            rate_list = user.getRatings();
            data_consulta = new Consulta3(user, rate_list.size());
            heap.insert(data_consulta);
        }

        Consulta3[] top = new Consulta3[10];
        for(int e = 0 ; e <= 9; e++){
            top[e] = heap.getMax();
            heap.deleteMax();
        }
        Lista rates;
        for (Consulta3 cons: top){
            cons.average_rate = 0;
            rates = cons.usuario.getRatings();
            for(int j = 0 ; j != rates.size() ; j++ ){
                cons.average_rate =  ((Rating)rates.get(j)).getRating() + cons.average_rate;
            }
            cons.average_rate = cons.average_rate/rates.size();
        }
        // FIXME ORDENAR TOP POR RATINGS PROLIJO
        bubbleSortcon3(top);
        for(Consulta3 consulta3 : top){
            System.out.println(" Id del usuario:" + consulta3.usuario.getUser_id() +
                "\n Cantidad:" + consulta3.rate_count +
                "\n Rating Promedio:" + consulta3.average_rate+"\n");
        }

    }



}
