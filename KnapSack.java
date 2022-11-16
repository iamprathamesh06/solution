import java.util.*;

public class KnapSack {
    static int N = 10000;
    static int dp[][] = new int[N][N];

    static int knapSack(int wt[], int val[], int n, int W) {
        if (W <= 0 || n <= 0)
            return 0;
        if (wt[n - 1] > W)
            return knapSack(wt, val, n - 1, W);
        int notPicked = knapSack(wt, val, n - 1, W);
        int picked = knapSack(wt, val, n - 1, W - wt[n - 1]) + val[n - 1];
        return Math.max(notPicked, picked);
    }

    // Optimization using DP

    // static int knapSack(int wt[], int val[], int n, int W) {
    // if (W <= 0 || n <= 0)
    // return 0;

    // if (dp[n][W] != -1)
    // return dp[n][W];
    // if (wt[n - 1] > W){
    // dp[n][W] = knapSack(wt, val, n - 1, W);
    // return dp[n][w];
    // }
    // int notPicked = knapSack(wt, val, n - 1, W);
    // int picked = knapSack(wt, val, n - 1, W - wt[n - 1]) + val[n - 1];
    // dp[n][W] = Math.max(notPicked, picked);

    // return dp[n][W];
    // }

    public static void main(String[] args) {

        // initialize DP
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        // end
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int W = sc.nextInt();

        int maxValue = knapSack(wt, val, n, W);
        System.out.println(maxValue);
    }
}
