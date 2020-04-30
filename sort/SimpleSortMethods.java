package sort;

import java.util.*;
// Time Complexity: O(n^2)
// Zone Complexity: O(1)
public class SimpleSortMethods {
    public static void main(String[] args) {
        int[] arrayList = new int[] {4, 5, 1, 2, -1, 0};
        bubbleSort(arrayList);
        for(Integer num: arrayList) {
            System.out.print(num + " ");
        }
    }
    // tail -> SORTED part
    public static void bubbleSort(int[] arrayList) {
        for(int j = arrayList.length - 1; j > 0; --j) {
            for(int i = 0; i < j; ++i) {
                if(arrayList[i] > arrayList[i + 1]) {
                    swap(arrayList, i, i + 1);
                }
            }
        }
    }
    // sorted part + unsorted part (pick and insert in the SORTED part)
    public static void insertionSort(int[] arrayList) {
        for(int j = 1; j < arrayList.length; ++j) {
            int pivot = arrayList[j];
            int i = j - 1;
            while(i >= 0 && pivot < arrayList[i]) {
                arrayList[i + 1] = arrayList[i--];
            }
            arrayList[i + 1] = pivot;
        }
    }
    // select smallest in the unsorted part
    public static void selectionSort(int[] arrayList) {
        for(int i = 0; i < arrayList.length; ++i) {
            for(int j = i + 1; j < arrayList.length; ++j) {
                if(arrayList[j] < arrayList[i]) {
                    swap(arrayList, i, j);
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}


