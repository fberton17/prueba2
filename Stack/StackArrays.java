public class StackArrays<T> implements MyStack<T> {

    public int ultimo;
    public T[] items;
    public boolean empty;
    public int size;

    public StackArrays(){
        this.ultimo = -1;
        this.empty = true;
    }

    public void pop() throws EmptyStackException {
        if(empty){throw new EmptyStackException();}
        else if(ultimo == 1){
            this.items[ultimo-1] = null;
            empty = true;
        }
        else{
            this.items[ultimo-1] = null;
            ultimo = ultimo -1;
        }
    }


    public T top() throws EmptyStackException {
        if(empty){throw new EmptyStackException();}
        else{
            return this.items[ultimo-1];
        }
    }


    public void push(T element) {
        try {
            if (empty) {
                this.items = (T[]) new Object[10];
                this.items[0] = element;
                ultimo = 1;
                empty = false;
                size = 10;

            } else {
                this.items[ultimo] = element;
                ultimo += 1;
                empty = false;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            T[] newarray = (T[]) new Object[size+10];
            for(int i=0 ; ultimo == i; i++){
                newarray[i] = this.items[i];
            }
            newarray[ultimo] = element;
            ultimo += 1;
            this.items = newarray;
            size += 10;
        }

    }

    boolean isEmpty() {
        return this.empty;
    }

    void makeEmpty() {
        T[] newarray = (T[]) new Object[10];
        this.items = newarray;
        empty = true;
    }

    public static void main(String[] args) throws EmptyStackException {
        StackArrays stac= new StackArrays();
        stac.push(1);
        System.out.println(stac.top());
        stac.push(2);
        System.out.println(stac.top());
        stac.push(3);
        System.out.println(stac.top());
        stac.push(4);
        System.out.println(stac.top());
        stac.push(5);
        System.out.println(stac.top());
        stac.push(6);
        System.out.println(stac.top());
        stac.push(7);
        System.out.println(stac.top());
        stac.push(8);
        System.out.println(stac.top());
        stac.push(9);
        System.out.println(stac.top());
        stac.push(10);
        System.out.println(stac.top());
        stac.push(11); // lugar 10
        System.out.println(stac.top());
        stac.push(12);
        System.out.println(stac.top());
        stac.pop();//12
        stac.pop();//11
        /*stac.pop();
        stac.pop();*/
        System.out.println(stac.items[0]);
        System.out.println(stac.ultimo);
        System.out.println(stac.top());

    }
}
