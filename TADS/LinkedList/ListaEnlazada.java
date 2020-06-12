package LinkedList;

import yqc.NodoList;

public class ListaEnlazada implements Lista{
    public NodoList primero;
    public NodoList ultimo;

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public void add(Object value) {
        NodoList nodo = new NodoList(value);
        if (primero == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
    }

    public void remove(int position) {
        NodoList actual = primero;
        NodoList borrar;
        for (int i = 0; i == position - 2; i++) {
            actual = actual.getSiguiente();
        }
        borrar = actual.getSiguiente();
        actual.setSiguiente(borrar.getSiguiente());
    }

    public Object get(int position) {
        if(primero != null) {
            NodoList actual = primero;
            NodoList borrar;
            for (int i = 0; i != position; i++) {
                if (actual.getSiguiente() != null){
                    actual = actual.getSiguiente();
                }else {return null;}
            }
            return actual.get();
        }
        return null;
    }

    public boolean contains(Object val) {
        NodoList actual = primero;
        boolean salir = false;
        if (val == ultimo) {
            salir = true;
        }
        while (actual != ultimo && !salir) {
            if (actual.get() == val) {
                salir = true;
            }
        }
        return salir;
    }

    public void addFirst(Object value) {
        NodoList nodo = new NodoList(value);
        nodo.setSiguiente(primero);
        primero = nodo;
    }

    public void addLast(Object value) {
        NodoList nodo = new NodoList(value);
        ultimo.setSiguiente(nodo);
        ultimo = nodo;
    }

    public void visualizar(ListaEnlazada lisobj) {
        NodoList actual;
        actual = this.primero;
        for (int i = 0; actual != this.ultimo; i++) {
            int n = (int) actual.get();
            boolean salir = false;
            int j = 1;
            NodoList actually = lisobj.primero;
            while (!salir) {
                if (j == n) {
                    System.out.println(actually.get().toString());
                    salir = true;
                }
                j++;
                actually = actually.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
    }

}

