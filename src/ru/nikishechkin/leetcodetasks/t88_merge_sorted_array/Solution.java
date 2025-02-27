package ru.nikishechkin.leetcodetasks.t88_merge_sorted_array;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class Solution {

    public static void main(String[] args) {
        // Test 1
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        // Test 2
//        int[] nums1 = {1};
//        int m = 1;
//        int[] nums2 = {};
//        int n = 0;

        // Test 3
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;

        merge2(nums1, m, nums2, n);
    }

    /**
     * Решение с дополнительным массивом
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; // Счетчик для первого массива
        int j = 0; // Счетчик для второго массива
        int[] res = new int[n + m]; // Результирующий массив
        for (int k = 0; k < m + n; k++) {

            if (i == m) { // Первый массив закончился
                res[k] = nums2[j];
                j++;
            } else if (j == n) { // Второй массив закончился
                res[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) { // Значение первого массива меньше
                res[k] = nums1[i];
                i++;
            } else { // Значение второго массива меньше
                res[k] = nums2[j];
                j++;
            }
        }
        nums1 = Arrays.copyOf(res, res.length);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Решение без дополнительного массива - заполняем исходный массив с конца
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Счетчик для первого массива
        int j = n - 1; // Счетчик для второго массива

        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) { // Первый массив закончился
                nums1[k] = nums2[j];
                j--;
            } else if (j < 0) { // Второй массив закончился
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) { // Значение первого массива меньше
                nums1[k] = nums1[i];
                i--;
            } else { // Значение второго массива меньше
                nums1[k] = nums2[j];
                j--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

}
