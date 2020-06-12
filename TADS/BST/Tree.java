package BST;

import java.util.ArrayList;
import java.util.List;

public class Tree<K extends Comparable<K>, T> implements MyTree<K,T> {
    public Node<K,T> root;

    public Tree(){
        this.root = null;
    }

    public void insert(K key, T data){
       this.root = insert(key,data, this.root);
    }

    public Node<K, T> insert(K key, T data, Node<K,T> subArbol) {
        if (subArbol == null){
            Node<K,T> node = new Node<K,T>(key,data);
            subArbol = node;

        }else{
            if(key.compareTo(subArbol.key) > 0){
                subArbol.rightChild = insert(key, data, subArbol.rightChild);
            }
            else if(key.compareTo(subArbol.key) < 0){
                subArbol.leftChild = insert(key, data, subArbol.leftChild);
            }
        }
        return subArbol;
    }

    @Override
    public T find(K key) {
        return contains(key , this.root);
    }

    private T contains(K key, Node<K,T> SubTree) {
        T valor = null;
        if (key.compareTo(SubTree.key) == 0){
            return SubTree.data;
        }
        else{
            if (key.compareTo(SubTree.key) > 0){
                valor = contains(key, SubTree.rightChild);
            } else if(key.compareTo(SubTree.key) < 0){
                valor = contains(key, SubTree.leftChild);
            }
        }
        return valor;
    }

    @Override
    public void delete(K key) {
        root = delete(key, root);
        //eliminar(key, this.root);
    }



    private Node<K, T> delete(K key, Node<K, T> root) {
        Node<K, T> returnTree = root;

        if (root.key.compareTo(key) == 0) {

            if (root.leftChild == null && root.rightChild == null) {

                returnTree = null;

            } else if (root.leftChild == null) {

                returnTree = root.rightChild;

            } else if (root.rightChild == null) {

                returnTree = root.leftChild;

            } else {

                Node<K, T>  min = buscarmax(key,root.leftChild);

                root.key = min.key;
                root.data = min.data;
                root.leftChild = delete(min.key, root.leftChild);

            }

        } else if (key.compareTo(root.key) > 0) {

            root.rightChild = delete(key, root.rightChild);

        } else {

            root.leftChild = delete(key, root.leftChild);

        }

        return returnTree;
    }

 /*   private Node<K,T> buscarmin(K key, Node<K,T> subTree) {
        Node<K,T> min;
        if(subTree.leftChild == null){
            return  subTree;
        }else{
            min = buscarmin(key, subTree.leftChild);
        }
        return min;
    }*/

    private Node<K,T> buscarmax(K key, Node<K,T> subTree) {
       Node<K,T> max;
        if(subTree.rightChild == null){
            return subTree;
        }
        else{
            max = buscarmax(key, subTree.rightChild);
        }
        return max;
    }

    @Override
    public List<K> inOrder() {
        List<K> lista = new ArrayList<>();
        inr(this.root, lista);
        return lista;
    }

    private void inr(Node<K,T> root, List<K> lista) {
        if(root != null){
            inr(root.leftChild, lista);
            lista.add(root.key);
            inr(root.rightChild, lista);
        }
    }

    @Override
    public List<K> preOrder() {
        List<K> lista = new ArrayList<>();
        pre(this.root, lista);
        return lista;
    }

    private void pre(Node<K,T> root, List<K> lista) {
        if (root != null){
            lista.add(root.key);
            pre(root.leftChild, lista);
            pre(root.rightChild, lista);
        }
    }

    @Override
    public List<K> postOrder() {
        List<K> lista = new ArrayList<>();
        pso(this.root, lista);
        return lista;
    }

    private void pso(Node<K,T> root, List<K> lista) {
        if(root != null){
            pso(root.leftChild, lista);
            pso(root.rightChild, lista);
            lista.add(root.key);
        }
    }


}
