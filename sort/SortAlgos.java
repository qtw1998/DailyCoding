package sort;
// https://site-pictures.oss-eu-west-1.aliyuncs.com/e7hyt.png
// MergeSort
// Time complexity: O(nlogn)
// Zone Complexity: O(n)
// Stack: O(logn) -> layer number
// Pile: O(nlogn) -> O(n)
public class SortAlgos {
    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 9, 2, 1};
        quickSort(array);
        for(int k = 0; k < array.length; ++k) {
            System.out.print(array[k] + " ");
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSortHelper(array, 0, array.length - 1, tmp);
    }

    private static void mergeSortHelper(int[] array, int left, int right, int[] tmp) {
        if(left >= right) return;
        int mid = left + (right - left) / 2; // take precautious of overflow
        mergeSortHelper(array, left, mid, tmp);
        mergeSortHelper(array, mid + 1, right, tmp);
        merge(array, left, right, tmp);
    }
    private static void merge(int[] array, int left, int right, int[] tmp) {
        int n = right - left + 1;
        int mid = left + (right - left) / 2;
        // int[] tmp = new int[n];
        int i = left, j = mid + 1;
        for(int k = 0; k < n; ++k) {
            if(i <= mid && (j > right || array[i] <= array[j])) {
                tmp[k] = array[i++];
            } else {
                tmp[k] = array[j++];
            }
        }
        for(int k = 0; k < n; k++) { // m
            array[left + k] = tmp[k];
        }
    }

    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }
    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) return;
        int i = left, j = right;
        int pivot = array[left + (right - left) / 2];

        while(i <= j) {
            while(i <= j && array[i] < pivot) {
                ++i;
            }
            while(i <= j && array[j] > pivot) {
                --j;
            }
            if(i <= j) {
                swap(array, i++, j--);
            }
        }
        quickSortHelper(array, left, j);
        quickSortHelper(array, i, right);
    }
}
