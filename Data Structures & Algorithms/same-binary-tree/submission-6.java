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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p); 
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            for(int i = q1.size(); i>0; i--){
                TreeNode np = q1.poll();
                TreeNode nq = q2.poll();

                if(np == null && nq == null) continue;

                if(np == null || nq == null || np.val != nq.val){
                    return false;
                }
                q1.add(np.left);
                q1.add(np.right);
                q2.add(nq.left);
                q2.add(nq.right);
            }
        }
        return true;
    }
}
