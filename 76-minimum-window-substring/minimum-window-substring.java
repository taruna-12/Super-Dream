class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        // Count characters required from t
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            window[c]++;

            // Character is useful and still needed
            if (need[c] > 0 && window[c] <= need[c]) {
                formed++;
            }

            // We have all required characters
            while (formed == required) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);
                window[remove]--;

                // Removing this character makes window invalid
                if (need[remove] > 0 &&
                    window[remove] < need[remove]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}