package BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                start = mid;
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
