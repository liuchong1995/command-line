package org.home.heap;

import java.util.Random;

/**
 * @Author: LiuChong
 * @Date: 2019-03-03 15:20
 * @Description:
 */
public class HeapSort {

    private HeapSort() {
    }

    public static void sort(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >=0 ; i--)
            shiftDown(arr,i,arr.length);
        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(arr,0,i);
            shiftDown(arr,0,i);
        }

    }



    private static void shiftDown(int[] arr, int k,int count) {
        while (2 * k + 1 < count) {
            int j = 2 * k + 1;
            if (j + 1 < count && arr[j] < arr[j + 1])
                j++;
            if (arr[k] > arr[j])
                break;
            swap(arr, k, j);
            k = j;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random(666);
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
        }
        HeapSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
        System.out.println("null");
    }
}
