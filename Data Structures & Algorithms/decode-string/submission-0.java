class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        int curn = 0;
        if(s.length() == 0 || s == null) return s;

        for(char x : s.toCharArray()){
            if(x >= '0' && x <= '9'){
                curn = (curn* 10)+(x-'0');
            } else{
                if(x =='['){
                    st1.push(curn);
                    curn = 0;
                    st2.push(String.valueOf(x));
                } else if(x == ']'){
                    String temp = "";
                    while(!st2.isEmpty() && !st2.peek().equals("[")){
                        temp = st2.pop()+temp;
                    }
                    st2.pop();
                    int nm = st1.pop();
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i<nm;++i){
                        sb.append(temp);
                    }
                    st2.push(sb.toString());
                } else{
                    st2.push(String.valueOf(x));
                }
            }
        }
        String ans = "";
        while(!st2.isEmpty()){
            ans = st2.pop()+ans;
        }
        return ans;
    }
}