package com.zc;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author yeyu
 * @since 2021/7/24 12:15 下午
 */
public final class SortUtils {
    public static void main(String[] args) {
        int[] its = {-10, -9, -1, 1, 4, 5, 6, 7, 10, 100, 109};
        bubbleSort(its);
        System.out.println(Objects.equals("hello", "world"));
        System.out.println(Arrays.toString(its));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = arr[i];
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    smallestIndex = j;
                    smallest = arr[j];
                }
            }
            if (i != smallestIndex) {
                int temp = arr[i];
                arr[i] = smallest;
                arr[smallestIndex] = temp;
            }
        }
    }

    public static void quickSort(int[] arr) {
    }

    public static void quickSortInner(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        while (low < high) {
            while (arr[low] <= arr[middle]) {
                low++;
            }
            while (arr[high] > arr[middle]) {
                high--;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                    changed = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!changed) {
                return;
            }
        }
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
