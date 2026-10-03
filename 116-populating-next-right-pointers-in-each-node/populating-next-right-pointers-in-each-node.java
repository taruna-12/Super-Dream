class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        // Link left child to right child
        root.left.next = root.right;
        
        // Link right child to neighbor's left child
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        
        // Recurse for left and right subtrees
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}