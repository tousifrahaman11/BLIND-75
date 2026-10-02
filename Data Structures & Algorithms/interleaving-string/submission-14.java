class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(0,0, s1,s2,s3,  dp);
    }
    boolean dfs(int x, int y, String s1, String s2, String s3, Boolean[][] dp){
        if(x == s1.length() && y == s2.length()) return true;

        if(dp[x][y] != null) return dp[x][y];
        int k = x+y;
        boolean result = false;
        
        if (x < s1.length() &&
            s1.charAt(x) == s3.charAt(k)) {
            result = dfs(x + 1, y, s1, s2, s3, dp);
        }

        if (!result && y < s2.length() &&
            s2.charAt(y) == s3.charAt(k)) {
            result = dfs(x, y + 1, s1, s2, s3, dp);
        }

        return dp[x][y] = result;
    }
}
