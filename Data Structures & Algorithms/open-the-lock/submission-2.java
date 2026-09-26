class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;

        Set<String> st = new HashSet<>(Arrays.asList(deadends)); //visited
        if(st.contains("0000")) return -1;

        Queue<String> q1 = new LinkedList<>();

        q1.offer("0000");
        st.add("0000");
        int steps = 0;

        while(!q1.isEmpty()){
            steps++;
            for(int i = q1.size(); i>0; i--){
                String lock = q1.poll();
                for(int j = 0; j<4; j++){
                    for(int move : new int[]{1,-1}){
                        char[] arr = lock.toCharArray();
                        arr[j] = (char)((arr[j] - '0' + move + 10) % 10 + '0');
                        String nextlock = new String(arr);

                        if(st.contains(nextlock)) continue;

                        if(nextlock.equals(target)) return steps;
                        q1.offer(nextlock);
                        st.add(nextlock);
                    }
                }
            }
        }
        return -1;
    }
}