public interface MinHeap<T> {
    void insertm(T value) throws HeapSizeOverflow;

    T getMin();

    void deleteMin();

    int sizem();
}
