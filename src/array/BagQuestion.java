
public class BagQuestion {
    public static void main(String[] args) {
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(knapsack(4, 3, wt, val));
    }

    /**
     * 背包问题，动态规划框架
     * @param W
     * @param N
     * @param wt
     * @param val
     * @return
     */
    public static int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N+1][W+1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[n-1]) {
                    dp[n][w] = dp[n-1][w];
                } else {
                    dp[n][w] = Math.max(dp[n-1][w], dp[n-1][w - wt[n-1]] + val[n-1]);
                }
            }
        }
        return dp[N][W];
    }
}