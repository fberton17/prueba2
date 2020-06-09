public class qLinkedList<T> implements PriorityQueue<T> {
    public NodoQueue<T> primero;
    public NodoQueue<T> ultimo;

    public qLinkedList(){
        primero = null;
        ultimo = null;
    }

    public void enqueueWithPriority(T element, int prioridad) {
        NodoQueue<T> nodo = new NodoQueue<>(element);
        nodo.setPrioridad(prioridad);
        if(primero==null || ultimo==null){
            primero = nodo;
            ultimo = nodo;
        }else if(nodo.getPrioridad() == ultimo.getPrioridad()){
            nodo.setSiguiente(ultimo);
            ultimo = nodo;
        }
        else if(nodo.getPrioridad() > primero.getPrioridad()){
            primero.setSiguiente(nodo);
            primero = nodo;
        }
        else{
            NodoQueue actual = ultimo;
            NodoQueue prox;
            while(nodo.getPrioridad() > actual.getPrioridad()){
                actual = actual.getSiguiente();
            }
            prox = actual.getSiguiente();
            actual.setSiguiente(nodo);
            nodo.setSiguiente(prox);
        }
    }


    public void enqueue(T element) {
        System.out.println("hola");
    }


    public T dequeue() throws EmptyQueueException {
        if (primero == ultimo && primero!= null){
            T retorno = primero.get();
            ultimo = null;
            primero = null;
            return retorno;
        }
        NodoQueue actual = ultimo;
        while(actual.getSiguiente() != primero){
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(null);
        T retorno = primero.get();
        primero = actual;
        return retorno;
    }


    public boolean isEmpty() {
        return primero == null;
    }

    public static void main(String[] args) throws EmptyQueueException {
        PriorityQueue<String> cola= new qLinkedList<>();

        cola.enqueueWithPriority("Peñarol", 10);
        cola.enqueueWithPriority("juventud", 5);
        cola.enqueueWithPriority("weise",7);
        cola.enqueueWithPriority("naciogay", 1);
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
    }
}
