import java.util.ArrayList;
import java.util.Vector;

public class LinkedList<T> implements MyStack<T>{
   public Nodo<T> primero;
   public Nodo<T> ultimo;


 public LinkedList(){
     primero = null;
     ultimo = null;
 }


 public void pop() throws EmptyStackException {
     if (ultimo == null || primero == null) throw (new EmptyStackException());
     else{
       Nodo<T> proxultimo = ultimo.getSiguiente();
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
         Nodo<T> nodo = new Nodo(element);
         primero = nodo;
         ultimo = nodo;
     } else {
         Nodo<T> nodo = new Nodo(element);
         nodo.setSiguiente(ultimo);
         ultimo = nodo;
     }
 }
 public static void postfija(String expresion) throws EmptyStackException {
     MyStack<Integer> pila = new LinkedList<>();
     MyStack<Character> charlist= new LinkedList<>();
     for(int i = 0; i == expresion.length()-1 ; i++){
         if(expresion.charAt(i) != ' ' && expresion.charAt(i) != '+' && expresion.charAt(i) != '-' && expresion.charAt(i) != '*'){
            charlist.push(expresion.charAt(i));

         }else if(expresion.charAt(i) == ' '){
             char char1 = charlist.top();
             charlist.pop();
             char char2 = charlist.top();
             charlist.pop();
             String Snum = String.valueOf(char1 + char2);
             System.out.println(Snum);
             int numero = Integer.parseInt(Snum);
             System.out.println(numero);
             pila.push(numero);}
         else if(expresion.charAt(i) == '+' && expresion.charAt(i) == '-' && expresion.charAt(i) == '*'){
             int num1;
             int num2;
             int res;
             switch (expresion.charAt(i)){
                 case '+':
                     num1 = pila.top();
                     pila.pop();
                     num2 = pila.top();
                     res = num1 + num2;
                     pila.push(res);
                     break;
                 case '-':
                     num1 = pila.top();
                     pila.pop();
                     num2 = pila.top();
                     pila.pop();
                     res = num1 - num2;
                     pila.push(res);
                     break;
                 case '*':
                     num1 = pila.top();
                     pila.pop();
                     num2 = pila.top();
                     pila.pop();
                     res = num1 * num2;
                     pila.push(res);
                     break;
             }
         }
     }
     System.out.println(pila.top());
 }


}

