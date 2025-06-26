import java.util.Arrays;

public class CoinChange {

    // 322
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int) 1e9);

        int ans = coinChange(coins, amount, dp);
        return ans >= (int) 1e8 ? -1 : ans;
    }

    public int coinChange(int[] arr, int tar, int[] dp) {
        if (tar == 0) {
            return dp[tar] = 0;
        }

        if (dp[tar] != (int) 1e9)
            return dp[tar];

        int minCount = (int) 1e8;
        for (int ele : arr) {
            if (tar - ele >= 0) {
                minCount = Math.min(minCount, coinChange(arr, tar - ele, dp) + 1);
            }
        }

        return dp[tar] = minCount >= (int) 1e8 ? (int) 1e8 : minCount;
    }

    public int coinChange_DP(int[] arr, int Tar, int[] dp) {
        for (int tar = 0; tar <= Tar; tar++) {
            if (tar == 0) {
                dp[tar] = 0;
                continue;
            }

            int minCount = (int) 1e8;
            for (int ele : arr) {
                if (tar - ele >= 0) {
                    minCount = Math.min(minCount, dp[tar - ele] + 1);
                }
            }

            dp[tar] = minCount >= (int) 1e8 ? (int) 1e8 : minCount;
        }

        return dp[Tar];
    }

    
}