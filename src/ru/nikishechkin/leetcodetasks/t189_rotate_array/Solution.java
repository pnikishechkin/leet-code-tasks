package ru.nikishechkin.leetcodetasks.t189_rotate_array;

import java.util.Arrays;

/**
 * 189. Rotate array
 * <p>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Дан целочисленный массив nums. Повернуть массив вправо на k шагов, где k — неотрицательное число.
 * <p>
 * - Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * - Could you do it in-place with O(1) extra space?
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int k = 2;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        if (k == 0 || nums.length == 1) {
            return;
        }

        int[] res = new int[nums.length];

        // Заполнение первой части массива: элементов, пришедших с конца и сдвинутых первых
        for (int i = 0; i < k; i++) {
            res[i] = nums[nums.length - k + i];
            if (k + i < nums.length) {
                res[k + i] = nums[i];
            }
        }

        // Заполнение остальной части массива
        for (int i = k + 1; i < nums.length; i++) {
            res[i] = nums[i - k];
        }

        System.arraycopy(res, 0, nums, 0, nums.length);

        System.out.println(Arrays.toString(nums));
    }
}
