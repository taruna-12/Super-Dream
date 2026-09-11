class Solution {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = start;

        while (inorder[index] != rootValue) {
            index++;
        }

        // Build left subtree
        root.left = build(preorder, inorder, start, index - 1);

        // Build right subtree
        root.right = build(preorder, inorder, index + 1, end);

        return root;
    }
}