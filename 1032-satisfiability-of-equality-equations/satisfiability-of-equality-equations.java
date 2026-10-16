class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String s : equations) {
            if (s.charAt(1) == '=') {
                int a = find(s.charAt(0) - 'a', parent);
                int b = find(s.charAt(3) - 'a', parent);
                parent[a] = b;
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int a = find(s.charAt(0) - 'a', parent);
                int b = find(s.charAt(3) - 'a', parent);

                if (a == b) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}