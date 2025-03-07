package ru.nikishechkin.leetcodetasks.t27_remove_element;

import java.util.Arrays;

/**
 *  Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 *  The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 *
 * Return k.
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = {0,1,2,2,3,0,4,2};
        removeElement(num, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0; // текущая позиция и итоговый счетчик

        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                i++; // текущая позиция в массиве, от которой продолжаем проверку
                j++; // итоговый счетчик и позиция нового массива
            } else {
                i++;
            }
        }
        System.out.println(j);
        System.out.println(Arrays.toString(nums));
        return j;
    }
}
