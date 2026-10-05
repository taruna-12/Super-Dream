class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        dfs(root, 0, 0, map);

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    void dfs(TreeNode root, int row, int col,
             TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {

        if (root == null)
            return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());

        map.get(col).get(row).add(root.val);

        dfs(root.left, row + 1, col - 1, map);
        dfs(root.right, row + 1, col + 1, map);
    }
}