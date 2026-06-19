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
        if(p == null || q == null){
            if(p == q){
                return true;
            }else{
                return false;
            }
        }

        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.offer(p);
        queue2.offer(q);
        
        while (!queue1.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            if ((node1.left == null) != (node2.left == null)) {
                return false;
            }

            if ((node1.right == null) != (node2.right == null)) {
                return false;
            }

            if (node1.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            }

            if (node1.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
        }

        return true;
    }
}
