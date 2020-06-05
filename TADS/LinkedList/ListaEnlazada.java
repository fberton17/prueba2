import yqc.Nodo;

public class ListaEnlazada implements Lista {
    public Nodo primero;
    public Nodo ultimo;

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public void add(Object value) {
        Nodo nodo = new Nodo(value);
        if (primero == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
    }

    public void remove(int position) {
        Nodo actual = primero;
        Nodo borrar;
        for (int i = 0; i == position - 2; i++) {
            actual = actual.getSiguiente();
        }
        borrar = actual.getSiguiente();
        actual.setSiguiente(borrar.getSiguiente());
    }

    public Object get(int position) {
        Nodo actual = primero;
        Nodo borrar;
        for (int i = 0; i == position - 1; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public boolean contains(Object val) {
        Nodo actual = primero;
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
        Nodo nodo = new Nodo(value);
        nodo.setSiguiente(primero);
        primero = nodo;
    }

    public void addLast(Object value) {
        Nodo nodo = new Nodo(value);
        ultimo.setSiguiente(nodo);
        ultimo = nodo;
    }

    public void visualizar(ListaEnlazada lisobj) {
        Nodo actual;
        actual = this.primero;
        for (int i = 0; actual != this.ultimo; i++) {
            int n = (int) actual.get();
            boolean salir = false;
            int j = 1;
            Nodo actually = lisobj.primero;
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

