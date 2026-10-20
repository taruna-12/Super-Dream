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
    private String smallest = "~"; // '~' is lexicographically greater than all lowercase letters

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        // Convert 0 -> 'a', 1 -> 'b', ..., 25 -> 'z'
        path.append((char) ('a' + node.val));

        // Leaf node reached
        if (node.left == null && node.right == null) {
            // Path needs to be from leaf to root, so reverse the accumulated string
            String current = new StringBuilder(path).reverse().toString();
            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
        } else {
            dfs(node.left, path);
            dfs(node.right, path);
        }

        // Backtrack
        path.deleteCharAt(path.length() - 1);
    }
}