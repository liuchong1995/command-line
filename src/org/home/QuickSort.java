package org.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class QuickSort {

    private void quickSort(int[] arr, int l, int h) {
        if (l >= h)
            return;
        int j = partition(arr, l, h);
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1, h);
    }


    private int partition(int[] arr, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (arr[++i] < arr[l] && i < h) ;
            while (arr[--j] > arr[l] && j > l) ;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] integers = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            integers[i] = (random.nextInt(1000000));
        }
        QuickSort sort = new QuickSort();
        long l = System.currentTimeMillis();

        sort.quickSort(integers,0,integers.length - 1);
        long last = System.currentTimeMillis() - l;
        System.out.println(last);
    }
}
