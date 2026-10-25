import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");

            String local = parts[0].replace(".", "");

            int plus = local.indexOf("+");

            if (plus != -1) {
                local = local.substring(0, plus);
            }

            String newEmail = local + "@" + parts[1];

            set.add(newEmail);
        }

        return set.size();
    }
}