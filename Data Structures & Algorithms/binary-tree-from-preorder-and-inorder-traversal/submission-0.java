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
    int pidx = 0;
    int inidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }
    TreeNode dfs(int[] preorder, int[] inorder, int lim){
        if(pidx >= preorder.length ) return null;
        if(inorder[inidx] == lim){
            inidx++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pidx++]);
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, lim);
        return root;
    }
}
