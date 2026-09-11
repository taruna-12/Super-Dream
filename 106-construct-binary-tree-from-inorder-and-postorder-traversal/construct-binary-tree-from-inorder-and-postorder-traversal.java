class Solution {
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // Last element in postorder is the root
        int rootValue = postorder[postIndex];
        postIndex--;

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = start;

        while (inorder[index] != rootValue) {
            index++;
        }

        // IMPORTANT: Build right first
        root.right = build(inorder, postorder, index + 1, end);

        // Then build left
        root.left = build(inorder, postorder, start, index - 1);

        return root;
    }
}
