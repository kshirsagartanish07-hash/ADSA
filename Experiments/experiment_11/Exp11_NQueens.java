import java.util.Scanner;

public class Exp11_NQueens {
    static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    static boolean solveNQUtil(int[][] board, int col, int N) {
        if (col >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1, N)) return true;

                board[i][col] = 0; // Backtrack
            }
        }

        return false;
    }

    static void solveNQueens(int N) {
        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0, N)) {
            System.out.println("Solution does not exist for N = " + N);
            return;
        }

        System.out.println("Solution configuration for " + N + "-Queens:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for N: ");
        int N = sc.nextInt();

        solveNQueens(N);
    }
}