class Solution {
    public int findKthLargest(int[] nums, int k) {

        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int pivot = nums[left + (right - left) / 2];

            int low = left;
            int mid = left;
            int high = right;

            while (mid <= high) {

                if (nums[mid] < pivot) {

                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;

                    low++;
                    mid++;
                }

                else if (nums[mid] > pivot) {

                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;

                    high--;
                }

                else {
                    mid++;
                }
            }

            // [left ... low-1] < pivot
            // [low ... high]   == pivot
            // [high+1 ... right] > pivot

            if (target < low) {
                right = low - 1;
            }

            else if (target > high) {
                left = high + 1;
            }

            else {
                return pivot;
            }
        }

        return -1;
    }
}