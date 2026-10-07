import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Binary_Tree_Traversals{
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

    static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        System.out.println("--- Construct Binary Tree ---");
        Node root = createTree();

        System.out.print("\nPre-order Traversal: ");
        preOrder(root);
        System.out.print("\nIn-order Traversal: ");
        inOrder(root);
        System.out.print("\nPost-order Traversal: ");
        postOrder(root);
        System.out.println();
    }
}