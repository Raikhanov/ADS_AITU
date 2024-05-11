public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert some elements into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print the size of the tree
        System.out.println("Size of the tree: " + tree.size());

        // Print the elements of the tree using in-order traversal
        System.out.print("In-order traversal: ");
        tree.inOrder();
        System.out.println();

        // Print the key-value pairs using the iterator
        System.out.println("Key-value pairs:");
        for (Object elem : tree) {
            BinaryTree.TreeEntry entry = (BinaryTree.TreeEntry) elem;
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
    }
}
