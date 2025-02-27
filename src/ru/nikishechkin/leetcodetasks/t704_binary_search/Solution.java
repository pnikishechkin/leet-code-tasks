package ru.nikishechkin.leetcodetasks.t704_binary_search;

/**
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
 * to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * 704. Бинарный поиск
 * Дан массив целых чисел nums, отсортированных в порядке возрастания, и целое число target, напишите функцию для
 * поиска target в nums. Если target существует, верните его индекс. В противном случае возвращайтесь -1.
 * Вы должны написать алгоритм со O(log n)сложностью выполнения.
 */
class Solution {

    /*
    0 2 3 5 7 10 12 15
    15
    2

    0 7
    pos = 3
    5

    4 7
    pos = 5
    10

    6 7
    pos = 6
    12

    7 7
    pos = 6

    0 7
    pos = 3
    5

    0 2
    pos = 1
    2

    2 2


     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = 0;

        while (true) {
            // Обращаемся к элементу массива, находящемуся посередине между выбранными граничными значениями
            pos = left + ((right - left) / 2);

            // Границы "сомкнулись" или вышли за пределы, но число так и не найдено
            if ((left == right && target != nums[left]) || right < 0 || left > nums.length - 1) {
                return -1;
            }

            if (target > nums[pos]) {
                // Если искомое значение больше, то сдвигаем левую границу вправо от центра
                left = pos + 1;
            } else if (target < nums[pos]) {
                // Если искомое значение меньше, то сдвигаем правую границу влево от центра
                right = pos - 1;
            } else {
                // Искомое число найдено
                return pos;
            }
        }

    }
    public static void main(String[] args) {
        int[] mas = {0, 2, 3, 5, 7, 10, 12, 15, 18};

        System.out.println(search(mas, 2)); // 1
        System.out.println(search(mas, 10)); // 5
        System.out.println(search(mas, 0)); // 0
        System.out.println(search(mas, 15)); // 7
        System.out.println(search(mas, 4)); // -1
        System.out.println(search(mas, 20)); // -1
        System.out.println(search(mas, -5)); // -1

        int[] mas2 = {2, 5};
        System.out.println(search(mas2, 0)); // -1

    }
}
