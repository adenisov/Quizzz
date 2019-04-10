public class UniquePathInGrid {
    public void solve() {
        int[][] a = new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 1, 0, 0},
                new int[]{0, 1, 0, 1},
                new int[]{0, 0, 0, 0}
        };

        int M = 4, N = 4;

        solveInternal(a, M, N);
    }

    private void solveInternal(int[][] a, int m, int n) {
        // Prepare DP
        // Array for DP intermediate results
        int[][] dp = new int[m][n];

        // There is always 1 way to start point
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = 0, d = 0;

                // r -> can reach from going to the right?
                // d -> can reach from going down?

                // Obstacle hit
                if (a[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (j != 0) {
                    r = dp[i][j - 1];
                }

                if (i != 0) {
                    d = dp[i - 1][j];
                }

                dp[i][j] = dp[i][j] + r + d;
            }
        }

        print(dp, m, n);
        System.out.println(String.format("Paths: %d", dp[n - 1][m - 1]));
    }

    private void print(int[][] a, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%d\t", a[i][j]));
            }
            System.out.println();
        }
    }
}
