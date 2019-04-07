public class RearrangeAlphabetAndNums {
    public void solve() {
        String input = "ACC1C2BEEW3";

        System.out.println(String.format("Result: %s", solveInternal(input)));
    }

    private String solveInternal(String s) {
        int numSum = 0;
        int N = s.length();
        final int MAX_LENGTH = 26;
        int[] chars = new int[MAX_LENGTH];

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                chars[c - 'A']++;
            } else {
                numSum += c - '0';
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (chars[i] > 0){
                while (chars[i]-- > 0) {
                    builder.append((char) ('A' + i));
                }
            }
        }

        builder.append(numSum);

        return builder.toString();
    }
}
