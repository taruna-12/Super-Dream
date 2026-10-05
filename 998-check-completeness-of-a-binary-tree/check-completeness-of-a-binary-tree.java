class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                foundNull = true;
            } else {
                if (foundNull)
                    return false;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}