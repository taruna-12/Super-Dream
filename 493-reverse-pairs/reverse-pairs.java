class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);

        // Count reverse pairs
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right &&
                   (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        // Merge the two sorted halves
        merge(nums, left, mid, right);

        return count;
    }

    public void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }
}