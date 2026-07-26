class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0]){
                int[] pr = st.pop();
                res[pr[1]] = i - pr[1];
            }
            st.push(new int[]{t, i});
        }
        return res;
    }
}
