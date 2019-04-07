public class MaxSumMultiple {

    public void solve() {
        String input = "101230";
        // solution: ((((1 + 0) + 1) * 2) * 3) + 0 = 12
        // 0, 1 -> +, otherwise -> *

        System.out.println(String.format("Sum: %s", solveInternal(input)));
    }

    private int solveInternal(String input) {
        // pretend we're using ASCII
        int sum = input.charAt(0) - '0';

        for (int i = 1; i < input.length(); i++) {
            int n = input.charAt(i) - '0';
            if (n < 2 || sum < 2) {
                sum += n;
            } else {
                sum *= n;
            }
        }

        return sum;
    }
}
