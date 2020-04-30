package sort;

import java.util.*;

public class SortInJava {
    public static void main(String[] args) {
        int[] arrayList = new int[] {4, 5, 1, 2, -1, 0};
        insertionSort(arrayList);
        for(Integer num: arrayList) {
            System.out.print(num + " ");
        }
    }
    public static void bubbleSort(int[] arrayList) {

    }

    public static void insertionSort(int[] arrayList) {

    }
    // choose smallest in the unsorted part
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


