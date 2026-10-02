import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HashFunction {

    static final int SIZE = 10;
    static ArrayList<LinkedList<Integer>> table = new ArrayList<>();

    // The hash function (division method)
    static int hash(int key) {
        return Math.abs(key) % SIZE;
    }

    static void insert(int key) {
        table.get(hash(key)).add(key);
    }

    static boolean search(int key) {
        return table.get(hash(key)).contains(key);
    }

    static void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " -> " + table.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < SIZE; i++) {
            table.add(new LinkedList<>());
        }

        int choice;
        do {
            System.out.println("\n1. Insert  2. Search  3. Display  4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int key = sc.nextInt();
                    insert(key);
                    System.out.println(key + " stored at index " + hash(key));
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    int k = sc.nextInt();
                    if (search(k)) {
                        System.out.println(k + " found at index " + hash(k));
                    } else {
                        System.out.println(k + " not found");
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        sc.close();
    }
}