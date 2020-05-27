package yqc;

public class Nodo {
    private Object value;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Object value) {
        this.value = value;
        this.siguiente = null;
    }

    public Object get(){
        return this.value;
    }
    public void set(Object value){
        this.value = value;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public void setAnterior(Nodo anterior){this.anterior = anterior;}
    public Nodo getAnterior(){return this.anterior;}
}
