import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree implements Iterable {
    public Node root;
    private int size;

    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public class TreeEntry {
        int key;
        int value;

        public TreeEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public void insert(int data) {
        root = insert(root, data);
        size++;
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = insert(current.left, data);
        } else {
            current.right = insert(current.right, data);
        }
        return current;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void remove(int data) {
        root = remove(root, data);
        size--;
    }

    private Node remove(Node current, int data) {
        if (current == null)
            return null;
        if (data < current.data)
            current.left = remove(current.left, data);
        else if (data > current.data)
            current.right = remove(current.right, data);
        else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null)
                return current.right;

            if (current.right == null)
                return current.left;

            int smallestValue = findSmallestValue(current.left);
            current.data = smallestValue;
            current.left = remove(current.left, smallestValue);

        }
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.right);
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new InOrderIterator(root);
    }

    private class InOrderIterator implements Iterator {
        private Node current;
        private java.util.Stack<Node> stack;

        public InOrderIterator(Node root) {
            current = root;
            stack = new java.util.Stack<>();
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        @Override
        public Object next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the tree.");
            }

            current = stack.pop();
            TreeEntry entry = new TreeEntry(current.data, current.data);
            current = current.right;
            return entry;
        }
    }
}
