package Heap;

public interface MaxHeap<T> {
    void insert(T value) throws HeapSizeOverflow;

    T getMax();

    void deleteMax();

    int size();

}
