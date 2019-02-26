package org.home;

import java.util.Arrays;

/**
 * @Author: LiuChong
 * @Date: 2019-02-22 22:43
 * @Description:
 */
public class Reverse {


    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(9, 0, 10);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
        new Reverse().reverse(integers);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    void reverse(Integer[] arr){
        reverse(arr,0,arr.length-1);
    }

    void reverse(Integer[] arr,int i, int j){
        if (i >= j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverse(arr,i+1,j-1);
    }
}
