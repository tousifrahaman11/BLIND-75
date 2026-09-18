class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> st = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0, 0, n, st, sb);
        return st;
    }
    static void backtrack(int op, int cl, int n, List<String> st, StringBuilder sb){
        if(op == cl && op == n){
            st.add(sb.toString());
            return;
        }
        if(op < n){
            sb.append('(');
            backtrack(op+1, cl, n, st, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(cl<op){
            sb.append(')');
            backtrack(op, cl+1, n, st, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
