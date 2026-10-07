import java.util.*;

public class Exp06_OptimalStorageTape {
    public static void optimalStorageOnTape(int[] lengths) {
        int n = lengths.length;
        Arrays.sort(lengths);

        System.out.print("Optimal retrieval order of program lengths: ");
        for (int len : lengths) {
            System.out.print(len + " ");
        }
        System.out.println();

        double totalRetrievalTime = 0;
        double currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += lengths[i];
            totalRetrievalTime += currentSum;
        }

        double mrt = totalRetrievalTime / n;
        System.out.println("Mean Retrieval Time (MRT): " + mrt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of programs: ");
        int n = sc.nextInt();

        int[] lengths = new int[n];
        System.out.println("Enter program lengths:");
        for (int i = 0; i < n; i++) {
            lengths[i] = sc.nextInt();
        }

        optimalStorageOnTape(lengths);
    }
}