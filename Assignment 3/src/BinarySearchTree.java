import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size;

    // Constructor, put, get, size methods, and other methods

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new InOrderIterator(root);
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private class InOrderIterator implements Iterator<Node<K, V>> {
        private Node<K, V> current;
        private Stack<Node<K, V>> stack;

        public InOrderIterator(Node<K, V> root) {
            current = root;
            stack = new Stack<>();
            fillStack(current);
        }

        private void fillStack(Node<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<K, V> node = stack.pop();
            fillStack(node.right);
            return node;
        }
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
