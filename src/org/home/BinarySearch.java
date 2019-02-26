package org.home;

import java.util.Arrays;

/**
 * @Author: LiuChong
 * @Date: 2019-02-22 22:58
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(10, 5, 12);
        Arrays.sort(integers);
        int i = search(integers, 0, integers.length-1, 10);
        System.out.println();
    }

    static int  search(Integer[] arr,int low, int height, int target){
        if (low > height)
            return -1;
        int mid = low + (height - low)/2;
        if (arr[mid].equals(target))
            return mid;
        if (arr[mid] > target)
            return search(arr,mid + 1,height,target);
        return search(arr,low,mid - 1,target);
    }
}
