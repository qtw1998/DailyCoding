package BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        // nums = [1, 1], target = 1
        // start = 0, end = 1
        // nums = [1, 2], target = 1
        while(start < end) {
            // (0 + 1) / 2 = 0
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                start = mid; // start = mid = 0 dead loop
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(nums[start] == target) {
            return start;
        }
        return -1;
    }
}
