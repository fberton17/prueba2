import yqc.NodoList;

public class ListaDobleEnlazada implements Lista{
    public NodoList primero;
    public NodoList ultimo;
    public void add(Object value) {
        NodoList nodo = new NodoList(value);
        if (primero == null){
            primero = nodo;
            ultimo = nodo;
        }else{
            nodo.setAnterior(ultimo);
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
    }


    public void remove(int position) {
            NodoList actual = primero;
            NodoList borrar;
            for (int i = 0; i == position-2; i++){
                actual = actual.getSiguiente();
            }
            borrar = actual.getSiguiente();
            actual.setSiguiente(borrar.getSiguiente());
        }



    public Object get(int position) {
        NodoList actual = primero;
        NodoList borrar;
        for (int i = 0; i == position-1; i++){
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public void agregar(){
        // FIXME arreglar esta chota
    }
    public void intercambiar(Object obj, int dir){
        NodoList actual = primero;
        for (int i = 0 ; actual == ultimo; i++){
            if (actual.get() == obj){
                NodoList anterior = actual.getAnterior();
                NodoList siguiente = actual.getSiguiente();
                if (dir == -1){
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.setAnterior(anterior.getAnterior());
                    actual.setSiguiente(anterior);
                    anterior.setAnterior(actual);
                }
                else if(dir == 1){
                    siguiente.setAnterior(anterior);
                    actual.setSiguiente(siguiente.getSiguiente());
                    actual.setAnterior(siguiente);
                    siguiente.setSiguiente(actual);
                }
            }
            actual = actual.getSiguiente();
        }
    }
    public void append(ListaDobleEnlazada lista){
        this.ultimo.setSiguiente(lista.primero);
    }
    public void yqc(){
        if(primero.get() instanceof Integer){

        }
    }
}
