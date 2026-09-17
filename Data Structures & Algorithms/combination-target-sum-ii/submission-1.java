class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> li = new ArrayList<>();
        backt(0, candidates, target, new ArrayList<>(),li);
        return li;
    }
    void backt(int st, int[] candidates, int target, List<Integer> cur, List<List<Integer>> li){
        if(target == 0){
            li.add(new ArrayList<>(cur));
            return;
        }
        if(st == candidates.length || target < 0){
            return;
        }
        if(st == candidates.length){
            return;
        }
        int nx = st+1;

        while(nx < candidates.length && candidates[nx] == candidates[nx-1]){
            nx++;
        }

        if(candidates[st] <= target){
            cur.add(candidates[st]);
            backt(st+1, candidates, target - candidates[st], cur, li);
            cur.remove(cur.size()-1);
        }
        backt(nx, candidates, target, cur , li);
    }
}
