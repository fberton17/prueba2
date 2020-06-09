public class NodoStack<T> {
    public NodoStack siguiente;
    public T obj;
    private int prioridad;

    public int getPrioridad(){return this.prioridad;}
    public void setPrioridad(int pr){this.prioridad = pr;}
    public NodoStack(T ob){
        this.obj = ob;
    }
    public void setSiguiente(NodoStack nodo){
        this.siguiente = nodo;
    }
    public NodoStack getSiguiente(){
        return this.siguiente;
    }
    public T get(){
        return this.obj;
    }
    public void change(T ob){
        this.obj = ob;
    }

}
