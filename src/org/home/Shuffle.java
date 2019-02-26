package org.home;

import java.util.Random;

public class Shuffle {
    public static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1); // [0,i]
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
