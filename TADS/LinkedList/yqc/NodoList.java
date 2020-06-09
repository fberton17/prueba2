package yqc;

public class NodoList {
    private Object value;
    private NodoList siguiente;
    private NodoList anterior;

    public NodoList(Object value) {
        this.value = value;
        this.siguiente = null;
    }

    public Object get(){
        return this.value;
    }
    public void set(Object value){
        this.value = value;
    }
    public NodoList getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoList siguiente) {
        this.siguiente = siguiente;
    }
    public void setAnterior(NodoList anterior){this.anterior = anterior;}
    public NodoList getAnterior(){return this.anterior;}
}
