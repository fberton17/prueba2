public class Nodo<T> {
    public Nodo siguiente;
    public T obj;
    private int prioridad;

    public int getPrioridad(){return this.prioridad;}
    public void setPrioridad(int pr){this.prioridad = pr;}
    public Nodo(T ob){
        this.obj = ob;
    }
    public void setSiguiente(Nodo nodo){
        this.siguiente = nodo;
    }
    public Nodo getSiguiente(){
        return this.siguiente;
    }
    public T get(){
        return this.obj;
    }
    public void change(T ob){
        this.obj = ob;
    }

}
