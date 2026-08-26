class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> li = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            li.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            indegree[pre[1]]++;
            li.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for (int nei : li.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return finish == numCourses;
    }
}
