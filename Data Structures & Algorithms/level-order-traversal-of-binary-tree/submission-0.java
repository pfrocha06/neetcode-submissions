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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();

           for (int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();

                level.add(current.val);

                if(current.left != null){
                    queue.offer(current.left);
                }if (current.right != null){
                    queue.offer(current.right);
                }
            }

            if(!level.isEmpty()) result.add(level);
        }

        return result;
    }
}
