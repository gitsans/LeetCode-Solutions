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
    public static int minMax(TreeNode root, boolean flag) {
        if(!flag) {
            if(root==null) 
                return Integer.MAX_VALUE;
            int min = root.val;
            int l = minMax(root.left,flag);
            int r = minMax(root.right,flag);
            min = Math.min(Math.min(l,r),min);
            return min;
        }
        else {
            if(root==null) 
                return Integer.MIN_VALUE;
            int max = root.val;
            int l = minMax(root.left,flag);
            int r = minMax(root.right,flag);
            max = Math.max(Math.max(l,r),max);
            return max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        int min = minMax(root.right,false);
        int max = minMax(root.left,true);
        boolean l = isValidBST(root.left);
        boolean r = isValidBST(root.right);
        boolean temp = true;
        if(root.left!=null) 
            temp = temp && (root.val>root.left.val) && (root.val>max);
        if(root.right!=null)
            temp = temp && (root.val<root.right.val) && (root.val<min);
        return l&&r&&temp;
    }
}