package Heap;

public class HeapImpl<T extends Comparable<T>>implements MaxHeap<T> , MinHeap<T>{
    private T[] values;

    private int pointerLastValue;

    public HeapImpl(int size) {
        this.values = (T[]) new Comparable[size];
        pointerLastValue = 0;
    }

    @Override
    public void insert(T value) throws HeapSizeOverflow {
        if(value != null) {
            /*if (pointerLastValue == values.length) {

                throw new HeapSizeOverflow();
            }

            this.values[pointerLastValue] = value;
            int valuePosition = pointerLastValue;
            pointerLastValue++;

            while (valuePosition != 0 && value.compareTo(getFather(valuePosition)) > 0) {
                T tempValue = getFather(valuePosition);

                this.values[getFatherPosition(valuePosition)] = value;
                this.values[valuePosition] = tempValue;

                valuePosition = getFatherPosition(valuePosition);
            }
        }*/
            if (pointerLastValue == values.length) {

                throw new HeapSizeOverflow();
            }

            this.values[pointerLastValue] = value;
            int valuePosition = pointerLastValue;
            pointerLastValue++;

            while (valuePosition != 0 && value.compareTo(getFather(valuePosition)) > 0) {
                T tempValue = getFather(valuePosition);

                this.values[getFatherPosition(valuePosition)] = value;
                this.values[valuePosition] = tempValue;

                valuePosition = getFatherPosition(valuePosition);
            }
        }
    }

    @Override
    public T getMax() {
        T valueToReturn = null;

        if (pointerLastValue != 0) {
            valueToReturn = this.values[0];
        }

        return valueToReturn;
    }

    @Override
    public void deleteMax() {
        this.values[0] = values[pointerLastValue-1];
        pointerLastValue--;

        int valuePosition = 0;
        T value = this.values[valuePosition];
        T left = this.values[getLeftChildPosition(valuePosition)];
        T rigth = this.values[getRigthChildPosition(valuePosition)];

        //boolean lugarEncontrado = false;
       // while (!lugarEncontrado) {
            // ambos hijos estan por fuera o son null -> lugarEncontrado = true
            // ambos hijos son mas grandes

            // estas parado en Value
            //if (getRigthChildPosition(valuePosition))
       // }

        while((value.compareTo(left) < 0 || value.compareTo(rigth) < 0)
                && getLeftChildPosition(valuePosition) < pointerLastValue && getRigthChildPosition(valuePosition) < pointerLastValue){

            if (left.compareTo(rigth) > 0 ){
                try{
              this.values[valuePosition] = left;
              this.values[getLeftChildPosition(valuePosition)] = value;
              valuePosition = getLeftChildPosition(valuePosition);} catch (ArrayIndexOutOfBoundsException f){
                }
            }else{
                try{
                this.values[valuePosition] = rigth;
                this.values[getRigthChildPosition(valuePosition)] = value;
                valuePosition = getRigthChildPosition(valuePosition);
                } catch (ArrayIndexOutOfBoundsException f){
                }
            }
           try{ value = this.values[valuePosition];
            left = this.values[getLeftChildPosition(valuePosition)];
            rigth = this.values[getRigthChildPosition(valuePosition)];
           } catch (ArrayIndexOutOfBoundsException f){
           }
        }

    }



    @Override
    public int size() {
        return pointerLastValue;
    }

    @Override
    public void insertm(T value) throws HeapSizeOverflow {
        if (pointerLastValue == values.length) {

            throw new HeapSizeOverflow();
        }

        this.values[pointerLastValue] = value;
        int valuePosition = pointerLastValue;
        pointerLastValue++;

        while (valuePosition != 0 && value.compareTo(getFather(valuePosition)) < 0) {
            T tempValue = getFather(valuePosition);

            this.values[getFatherPosition(valuePosition)] = value;
            this.values[valuePosition] = tempValue;

            valuePosition = getFatherPosition(valuePosition);
        }
    }

    @Override
    public T getMin () {
        T valueToReturn = null;

        if (pointerLastValue != 0) {
            valueToReturn = this.values[0];
        }

        return valueToReturn;
    }

    @Override
    public void deleteMin () {
        this.values[0] = values[pointerLastValue-1];
        pointerLastValue--;

        int valuePosition = 0;
        T value = this.values[valuePosition];
        T left = this.values[getLeftChildPosition(valuePosition)];
        T rigth = this.values[getRigthChildPosition(valuePosition)];
        T aux;

        while(value.compareTo(left) > 0 || value.compareTo(rigth) > 0){
            if (values[getRigthChildPosition(valuePosition)].compareTo(values[getLeftChildPosition(valuePosition)]) > 0){

            }


            if (left.compareTo(rigth) < 0 ){

                this.values[valuePosition] = left;
                this.values[getLeftChildPosition(valuePosition)] = value;
                valuePosition = getLeftChildPosition(valuePosition);
            }else{

                this.values[valuePosition] = rigth;
                this.values[getRigthChildPosition(valuePosition)] = value;
                valuePosition = getRigthChildPosition(valuePosition);
            }
            value = this.values[valuePosition];
            left = this.values[getLeftChildPosition(valuePosition)];
            rigth = this.values[getRigthChildPosition(valuePosition)];
        }

    }

    @Override
    public int sizem () {
        return pointerLastValue;
    }

    private T getFather ( int childPosition){
        return values[(childPosition - 1) / 2];
    }

    private int getFatherPosition ( int childPosition){
        return (childPosition - 1) / 2;
    }

    private int getLeftChildPosition(int valuePosition){
        return (2*(valuePosition)) + 1;
    }

    private int getRigthChildPosition(int valuePosition){
        return (2*(valuePosition)) + 2;
    }


    public String toString() {
        int position = 0;
        int level = 0;
        String string = "";
        while (position < pointerLastValue) {
            if (!(position < (int) (Math.pow(2, level + 1) - 1))) {
                string += "\n";
                level ++;
            }
            string += this.values[position].toString();
            string += " ";
            position ++;
        }
        return string;
    }

}
