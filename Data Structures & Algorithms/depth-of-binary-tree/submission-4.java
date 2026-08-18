/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        
        Queue<TreeNode> st = new LinkedList<>();
        if(root != null){
            st.add(root);
        }
        int maxd = 0;
        while(!st.isEmpty()){
            int size = st.size();
            for(int i = 0; i<size; i++){
                TreeNode node = st.poll();
                if(node.left != null){
                    st.add(node.left);
                }
                if(node.right != null){
                    st.add(node.right);
                }
            }
            maxd++;
        }
        return maxd;
    }
}
