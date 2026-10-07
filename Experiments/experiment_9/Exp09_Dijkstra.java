import java.util.*;

public class Exp09_Dijkstra {
    static int minDistance(int[] dist, boolean[] sptSet, int V) {
        int minVal = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= minVal) {
                minVal = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    static void dijkstra(int[][] graph, int src, int V) {
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet, V);
            if (u == -1) break;

            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \t Distance from Source (" + src + ")");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println(i + " \t INF");
            else
                System.out.println(i + " \t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter weighted adjacency matrix (0 for no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        dijkstra(graph, src, V);
    }
}