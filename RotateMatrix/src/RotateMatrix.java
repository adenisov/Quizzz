public final class RotateMatrix {

    public void solve() {
        var a = new int[][] {
                new int[] { 1, 2, 3, 4, 5 },
                new int[] { 6, 7, 8, 9, 10 },
                new int[] { 11, 12, 13, 14, 15 },
                new int[] { 16, 17, 18, 19, 20 },
                new int[] { 21, 22, 23, 24, 25 }
        };

        var N = a.length;
        var M = N - 1;

        System.out.println("Before:\n\r");
        printMatrix(a, N);
        System.out.println();

        for (int j = 0; j < N / 2; j++) {
            for (int i = j; i < M - j; i++) {

                // preserve the starting point
                var temp = a[j][i];

                // down-left -> up-left
                a[j][i] = a[M - i][j];

                // down-right -> down-left
                a[M - i][j] = a[M - j][M - i];

                // top-right -> down-right
                a[M - j][M - i] = a[i][M - j];

                // restore starting point to the up-right
                a[i][M - j] = temp;
            }
        }

        System.out.println("After:\n\r");
        printMatrix(a, N);
    }

    private void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%s\t", matrix[i][j]));
            }
            System.out.println();
        }
    }
}
