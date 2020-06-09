public class NodoQueue<T> {
    public NodoQueue siguiente;
    public T obj;
    private int prioridad;

    public int getPrioridad(){return this.prioridad;}
    public void setPrioridad(int pr){this.prioridad = pr;}
    public NodoQueue(T ob){
        this.obj = ob;
    }
    public void setSiguiente(NodoQueue nodo){
        this.siguiente = nodo;
    }
    public NodoQueue getSiguiente(){
        return this.siguiente;
    }
    public T get(){
        return this.obj;
    }
    public void change(T ob){
        this.obj = ob;
    }

}
