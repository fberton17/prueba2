package Clases;

public class BubbleSort {
    void bubbleSort(Idioma arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].getCantidadreservas() < arr[j+1].getCantidadreservas())
                {
                    // swap temp and arr[i]
                    Idioma temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
