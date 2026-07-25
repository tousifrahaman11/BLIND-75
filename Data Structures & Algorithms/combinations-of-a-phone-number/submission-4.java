class Solution {
     String[] map = {
        "",     //0
        "",     //1
        "abc",  //2
        "def",  //3
        "ghi",  //4
        "jkl",  //5
        "mno",  //6
        "pqrs", //7
        "tuv",  //8
        "wxyz"  //9
    };
    public List<String> letterCombinations(String digits) {
        List<String> li = new ArrayList<>();
        if(digits.length() == 0){
            return li;
        }
        solve(0,digits, new StringBuilder(), li);
        return li;
    }
    void solve(int idx, String digits, StringBuilder sb, List<String> li){
        if(idx == digits.length()){
            li.add(sb.toString());
            return;
        }
        String let = map[digits.charAt(idx) - '0'];

        for(char ch : let.toCharArray()){
            sb.append(ch);
            solve(idx+1, digits, sb, li);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
