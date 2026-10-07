import java.util.Arrays;
import java.util.Scanner;

public class Exp12_HamiltonianCycle {
    static boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0) return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v) return false;

        return true;
    }

    static boolean hamCycleUtil(int[][] graph, int[] path, int pos, int V) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1, V)) return true;

                path[pos] = -1; // Backtrack
            }
        }

        return false;
    }

    static void hamCycle(int[][] graph, int V) {
        int[] path = new int[V];
        Arrays.fill(path, -1);
        path[0] = 0;

        if (!hamCycleUtil(graph, path, 1, V)) {
            System.out.println("No Hamiltonian Cycle exists.");
            return;
        }

        System.out.print("Hamiltonian Cycle path: ");
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter adjacency matrix (0 or 1):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        hamCycle(graph, V);
    }
}