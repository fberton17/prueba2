package BST;

public class Node<K, T> {
    public K key;
    public T data;
    Node<K, T> leftChild;
    Node<K, T> rightChild;

    public Node(K key, T value){
        this.key = key;
        this.data = value;
    }
}