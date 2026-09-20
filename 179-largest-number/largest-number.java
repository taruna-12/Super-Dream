class Solution {
    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // Convert numbers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort using our own comparison
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                String first = arr[j] + arr[j + 1];
                String second = arr[j + 1] + arr[j];

                if (first.compareTo(second) < 0) {

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // If largest number is 0
        if (arr[0].equals("0")) {
            return "0";
        }

        String result = "";

        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }

        return result;
    }
}