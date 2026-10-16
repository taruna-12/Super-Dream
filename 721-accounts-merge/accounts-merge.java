import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Map<String, Integer> emailOwner = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (emailOwner.containsKey(email)) {
                    union(i, emailOwner.get(email), parent);
                } else {
                    emailOwner.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> groups = new HashMap<>();

        for (String email : emailOwner.keySet()) {
            int root = find(emailOwner.get(email), parent);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (int root : groups.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(root).get(0));
            list.addAll(groups.get(root));
            result.add(list);
        }

        return result;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}