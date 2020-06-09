public class LinkedListQQ<T> implements MyQueue<T>, MyDoubleQueue<T>{
    public NodoQueue<T> primero;
    public NodoQueue<T> ultimo;

    public LinkedListQQ(){
        primero = null;
        ultimo = null;
    }

    public void enqueue(T element) {
        NodoQueue<T> nodo = new NodoQueue(element);
        if(primero == null || ultimo == null) {
            primero = nodo;
            ultimo = nodo;
        }else{
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
    }


    public T dequeue() throws EmptyQueueException {
        if (primero == null) {
            throw new EmptyQueueException();
        }
        T retorno = primero.get();
        primero = primero.getSiguiente();
        if (primero.getSiguiente() == null){ultimo = null;}
        return retorno;
    }

    @Override
    public void enqueueLeft(T element) {
        this.enqueue(element);
    }

    @Override
    public T dequeueLeft() throws EmptyQueueException {
        boolean salir = false;
        T retorno = null;
        NodoQueue actual = primero;
        while(!salir){
            if (actual.getSiguiente() == ultimo){
                retorno = ultimo.get();
                ultimo = actual;
                salir = true;
            }else if(actual.getSiguiente() == null){
                retorno = primero.get();
                primero = null;
                ultimo = null;
                return retorno;
            }
            actual = actual.getSiguiente();
        }
        return retorno;
    }

    @Override
    public void enqueueRight(T element) {
        NodoQueue<T> nodo = new NodoQueue(element);
        nodo.setSiguiente(primero);
        primero = nodo;
    }

    @Override
    public T dequeueRight() throws EmptyQueueException {
        final T dequeue = this.dequeue();
        return dequeue;
    }

    @Override
    public boolean isEmpty2() {
        return primero == null && ultimo == null;
    }

    public boolean isEmpty() {
        return primero == null || ultimo == null;
    }

    public static void main(String[] args) throws EmptyQueueException {


    }
}
