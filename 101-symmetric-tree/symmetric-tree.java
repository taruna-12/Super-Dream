class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {

        // Both are null
        if (left == null && right == null) {
            return true;
        }

        // One is null
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // Compare in mirror order
        return check(left.left, right.right) &&
               check(left.right, right.left);
    }
}