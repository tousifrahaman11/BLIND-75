class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inc = new int[n+1];
        int[] outc = new int[n+1];

        for(int[] t : trust){
            outc[t[0]]++;
            inc[t[1]]++;
        }

        for(int i = 1; i<=n; i++){
            if(outc[i] == 0 && inc[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}