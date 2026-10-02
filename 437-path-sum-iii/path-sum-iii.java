class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return count(root, targetSum)
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }

    public int count(TreeNode root, long target) {
        if (root == null) return 0;

        int ans = 0;

        if (root.val == target) {
            ans++;
        }

        ans += count(root.left, target - root.val);
        ans += count(root.right, target - root.val);

        return ans;
    }
}