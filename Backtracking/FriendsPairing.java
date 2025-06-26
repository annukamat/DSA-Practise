import java.util.Scanner;

public class FriendsPairing {

    public static int friendsPairingProblem(int n, int[] dp){
        if(n <= 1) return dp[n] = 1;
        if(dp[n] != 0) return dp[n];
        

        int single = friendsPairingProblem(n-1, dp);
        int pair = friendsPairingProblem(n-2, dp) * (n-1);
        int ans = single + pair;

        return dp[n] = ans;
    }

    public static int friendsPairingProblem_DP(int n, int[] dp){
        int N = n;

        for(n=0; n<=N; n++){
            if(n <= 1) {
                dp[n] = 1;
                continue;
            }

            int single = dp[n-1];  // friendsPairingProblem(n-1, dp);
            int pair = dp[n-2] * (n-1);  // friendsPairingProblem(n-2, dp) * (n-1);
            int ans = single + pair;

            dp[n] = ans;
        }
        return dp[N];
    }

    public static void friendsPairingProblem(int n) {
        int[] dp = new int[n + 1];
        int ans = friendsPairingProblem(n, dp);

        System.out.println(ans);
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            friendsPairingProblem(n);
        }
    }
    
}
