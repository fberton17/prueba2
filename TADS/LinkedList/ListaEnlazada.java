import yqc.NodoList;

public class ListaEnlazada implements Lista {
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
        NodoList actual = primero;
        NodoList borrar;
        for (int i = 0; i == position - 1; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
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

    public static void main(String[] args){
        ListaEnlazada listaI = new ListaEnlazada();
        listaI.add(1);
        listaI.add(2);
        listaI.add(3);
        listaI.add(5);
        listaI.visualizar(listaI);
        ListaEnlazada listaO = new ListaEnlazada();
        listaO.add('A');
        listaO.add('b');
        listaO.add('c');
        listaO.add('d');
        listaO.add('e');
        listaI.visualizar(listaO);
    }
}

