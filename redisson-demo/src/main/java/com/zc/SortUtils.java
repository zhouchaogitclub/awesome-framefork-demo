package com.zc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yeyu
 * @since 2021/7/24 12:15 下午
 */
public final class SortUtils {
    public static void main(String[] args) {
        int[] its = {1, -1, -9, 109, -10, 10, 5, 4, 6, 7, 100};
        selectionSort(its);
        System.out.println(Arrays.toString(its));
        List<Integer> ints = new ArrayList<>();
        ints.add(20);
        ints.add(30);
        ints.add(10);
        ints.subList(1, ints.size() - 1).add(100);
        System.out.println(ints);
        List<Integer> integers = Collections.unmodifiableList(ints);
        ints.add(200);
        System.out.println(integers);
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
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
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
}
