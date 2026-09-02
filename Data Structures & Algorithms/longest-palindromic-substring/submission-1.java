class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int st = 0;
        int maxl = 1;

        for(int i = 0; i<n; i++){
            dp[i][i] = true;
        }

        for(int len = 2; len <= n; len++){
            for(int i = 0; i+len-1<n; i++){
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len <= 2 || dp[i+1][j-1]){
                        dp[i][j] = true;

                        if(len > maxl){
                            maxl = len;
                            st = i;
                        }
                    }
                }
            }
        }
        return s.substring(st, maxl+st);
    }
}
