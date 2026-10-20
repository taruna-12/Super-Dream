import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        // Strip the outer '(' and ')'
        String digits = s.substring(1, s.length() - 1);
        int n = digits.length();

        // Partition into two non-empty components: [0, i) and [i, n)
        for (int i = 1; i < n; i++) {
            List<String> leftCandidates = generateValidNumbers(digits.substring(0, i));
            List<String> rightCandidates = generateValidNumbers(digits.substring(i));

            // Cross-combine every valid x and y
            for (String left : leftCandidates) {
                for (String right : rightCandidates) {
                    result.add("(" + left + ", " + right + ")");
                }
            }
        }

        return result;
    }

    private List<String> generateValidNumbers(String s) {
        List<String> valid = new ArrayList<>();
        int len = s.length();

        // 1. Consider s as an integer with no decimal point
        // Valid only if length is 1 or it does not have a leading zero
        if (len == 1 || s.charAt(0) != '0') {
            valid.add(s);
        }

        // 2. Consider placing a decimal point after index d (where 1 <= d < len)
        for (int d = 1; d < len; d++) {
            String intPart = s.substring(0, d);
            String fracPart = s.substring(d);

            // Integer part cannot have leading zeros unless it is "0"
            boolean validIntPart = (intPart.length() == 1 || intPart.charAt(0) != '0');

            // Fractional part cannot have trailing zeros
            boolean validFracPart = (fracPart.charAt(fracPart.length() - 1) != '0');

            if (validIntPart && validFracPart) {
                valid.add(intPart + "." + fracPart);
            }
        }

        return valid;
    }
}