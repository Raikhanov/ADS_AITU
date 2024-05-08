import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 6 keys and value ENTER");
        bst.put(sc.nextInt(), sc.nextLine());
        bst.put(sc.nextInt(), sc.nextLine());
        bst.put(sc.nextInt(), sc.nextLine());
        bst.put(sc.nextInt(), sc.nextLine());
        bst.put(sc.nextInt(), sc.nextLine());
        bst.put(sc.nextInt(), sc.nextLine());
        for (var node : bst) {
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
        }
    }
}
