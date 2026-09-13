class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        // Count letters in magazine
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        // Use letters for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {

            int index = ransomNote.charAt(i) - 'a';

            count[index]--;

            if (count[index] < 0) {
                return false;
            }
        }

        return true;
    }
}