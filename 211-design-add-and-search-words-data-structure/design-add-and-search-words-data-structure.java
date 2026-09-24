class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode current) {

        if (index == word.length()) {
            return current.isEnd;
        }

        char ch = word.charAt(index);

        if (ch != '.') {

            int pos = ch - 'a';

            if (current.children[pos] == null) {
                return false;
            }

            return searchHelper(word, index + 1, current.children[pos]);
        }

        // ch == '.'
        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                if (searchHelper(word, index + 1, current.children[i])) {
                    return true;
                }
            }
        }

        return false;
    }
}