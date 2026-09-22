class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));

        // Path passing through the current node
        int currentPath = left + root.val + right;

        maxSum = Math.max(maxSum, currentPath);

        // Return the best path that can continue to the parent
        return root.val + Math.max(left, right);
    }
}