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

        // Пример обхода дерева с помощью итератора и вывод ключей и значений
        for (var node : bst) {
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
        }
    }
}