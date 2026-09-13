class Solution {
    int index = 0;

    public NestedInteger deserialize(String s) {

        // If it is just a number
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        // Create an empty list
        NestedInteger result = new NestedInteger();

        index++; // skip '['

        while (index < s.length()) {

            // End of current list
            if (s.charAt(index) == ']') {
                index++;
                return result;
            }

            // Skip comma
            if (s.charAt(index) == ',') {
                index++;
                continue;
            }

            // Nested list
            if (s.charAt(index) == '[') {
                result.add(deserialize(s));
            }

            // Number
            else {
                int sign = 1;

                if (s.charAt(index) == '-') {
                    sign = -1;
                    index++;
                }

                int num = 0;

                while (index < s.length() &&
                       Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }

                result.add(new NestedInteger(num * sign));
            }
        }

        return result;
    }
}