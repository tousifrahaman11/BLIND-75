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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;

        TreeNode lft = lowestCommonAncestor(root.left, p, q);
        TreeNode rgt = lowestCommonAncestor(root.right, p, q);

        if(lft != null && rgt != null){
            return root;
        }
        return lft != null ? lft : rgt;
    }
}
