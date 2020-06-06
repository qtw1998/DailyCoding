//package sort;
//
//import static sort.Test.merge;
//
//public class Test {
//    public static void main(String args[]) {
//
//    }
//
//    public static MergeSort(int[] array) {
//        int[] tmp = new int[array.length];
//        MergeSortHelper(array, 0, array.length - 1, tmp);
//    }
//
//    private static MergeSortHelper(int[] array, int left, int right, int[] tmp) {
//        if(left >= right) return;
//        int mid = left + (right - left) / 2;
//
//        MergeSortHelper(array, left, mid, tmp);
//        MergeSortHelper(array, mid + 1, right, tmp);
//        merge(array, left, right, tmp);
//    }
//    private static merge(int[] array, int left, int right, int[] tmp) {
//        int mid = left + (right - left) / 2;
//        int i = left, j = mid + 1;
//        for(int k = 0; k < right - left; ++k) {
//            if()
//        }
//
//    }
//}
