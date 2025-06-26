
public class maxSumIncreasingSubs {

    public int maxSumRecur(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // initialize with current element

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

    }

}
