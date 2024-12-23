class Solution {
    
    private int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3002][1001];
        for (int[] i : dp) Arrays.fill(i,-1);
        return rNOW(startPos, endPos, startPos, k, dp);
        
    }

    public int rNOW(int s, int e, int c, int k, int[][] dp) {
        if (k == 0) return (c == e) ? 1 : 0;
        if (dp[c+1001][k] != -1) return dp[c+1001][k];
        int l = rNOW(s, e, c-1, k-1, dp)%mod;
        int r = rNOW(s, e, c+1, k-1, dp)%mod;
        return dp[c+1001][k] = (l+r)%mod;
    }
}