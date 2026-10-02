class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    public void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        if (path.equals("")) {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}