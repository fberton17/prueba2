public interface MyStack<T> {
    void pop () throws EmptyStackException;

    T top() throws EmptyStackException;

    void push(T element);
}
