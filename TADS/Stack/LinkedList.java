public class LinkedList<T> implements MyStack<T>{
   public NodoStack<T> primero;
   public NodoStack<T> ultimo;


 public LinkedList(){
     primero = null;
     ultimo = null;
 }


 public void pop() throws EmptyStackException {
     if (ultimo == null || primero == null) throw (new EmptyStackException());
     else{
         NodoStack<T> proxultimo = ultimo.getSiguiente();
       ultimo.setSiguiente(null);
       ultimo = proxultimo;
     }

    }


 public T top() throws EmptyStackException {
   if (ultimo == null || primero == null){
     throw  new  EmptyStackException();
   } else{
    return ultimo.get();
 }
  }


 public void push(T element) {
     if (null == primero || ultimo == null) {
         NodoStack<T> nodo = new NodoStack(element);
         primero = nodo;
         ultimo = nodo;
     } else {
         NodoStack<T> nodo = new NodoStack(element);
         nodo.setSiguiente(ultimo);
         ultimo = nodo;
     }
 }

 }




