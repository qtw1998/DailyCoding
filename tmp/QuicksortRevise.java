package tmp;

import java.util.*;

public class QuicksortRevise {
    public static void main(final String[] args) {
        int[] arrayList = new int[]{5, 3, 1, 2, 6, 4};
        quickSort(arrayList);
        for(Integer num: arrayList) {
            System.out.print(num + " ");
        }
    }
    public static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }
    public static void quickSortHelper(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = nums[left + (right - left) / 2];
        int i = left, j = right;
        while(i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <=j && nums[j] > pivot) {
                --j;
            }
            if(i <= j) {
                swap(nums, i++, j--);
            }
        }
        quickSortHelper(nums, left, j);
        quickSortHelper(nums, i, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
