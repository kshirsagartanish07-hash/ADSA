import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Exp04_BinaryTreeSearch {
    static Scanner sc = new Scanner(System.in);

    static Node createTree() {
        System.out.print("Enter node value (-1 for no node): ");
        int val = sc.nextInt();

        if (val == -1) return null;

        Node root = new Node(val);
        System.out.println("Enter left child of " + val);
        root.left = createTree();
        System.out.println("Enter right child of " + val);
        root.right = createTree();

        return root;
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static boolean searchKey(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return searchKey(root.left, key) || searchKey(root.right, key);
    }

    public static void main(String[] args) {
        Node root = createTree();

        System.out.print("\nIn-order Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        if (searchKey(root, key)) {
            System.out.println("Key " + key + " found in the Binary Tree.");
        } else {
            System.out.println("Key " + key + " not found in the Binary Tree.");
        }
    }
}