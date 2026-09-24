import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {

        // Insert all roots into Trie
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            String rootWord = findRoot(word);

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(rootWord);
        }

        return result.toString();
    }

    public void insert(String word) {

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

    public String findRoot(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];

            // First root found = shortest root
            if (current.isEnd) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}