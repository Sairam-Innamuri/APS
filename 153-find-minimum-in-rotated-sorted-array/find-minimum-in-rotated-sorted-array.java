class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // minimum is on right side
                left = mid + 1;
            } else {
                // minimum is mid or on left side
                right = mid;
            }
        }

        return nums[left];
    }
}