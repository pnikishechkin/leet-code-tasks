package ru.nikishechkin.leetcodetasks.t278_first_bad_version;

/**
 * 278. First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
 * of your product fails the quality check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 *
 * Первая плохая версия.
 * Вы менеджер по продукту и в настоящее время возглавляете команду по разработке нового продукта. К сожалению,
 * последняя версия вашего продукта не проходит проверку качества. Поскольку каждая версия разрабатывается на основе
 * предыдущей версии, все версии после плохой версии тоже плохие.
 *
 * Предположим, у вас есть nверсии [1, 2, ..., n], и вы хотите найти первую плохую версию, из-за которой все последующие
 * будут плохими.
 *
 * Вам предоставляется API bool isBadVersion(version), который возвращает, если version это плохо. Реализуйте функцию для
 * поиска первой плохой версии. Вы должны свести к минимуму количество обращений к API.
 */
public class Solution extends VersionControl {
    public static int firstBadVersion(int n) {

        int start = 1;
        int end = n;
        int middle = 0;

        while (start <= end) {
            middle = start + ((end - start) / 2);
            System.out.println(start + " " + end + " " + middle + "-" + isBadVersion(middle));
            if (isBadVersion(middle)) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {

/*
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        0 0 0 0 0 0 1 1 1 1  1  1  1  1  1  1

        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        1 1 1 1 1 1 1 1 1 1  1  1  1  1  1  1
*/

        badVersion = 1;
        System.out.println(firstBadVersion(16));

        badVersion = 2;
        System.out.println(firstBadVersion(16));

        badVersion = 11;
        System.out.println(firstBadVersion(16));

        badVersion = 12;
        System.out.println(firstBadVersion(16));

        badVersion = 15;
        System.out.println(firstBadVersion(16));

        badVersion = 16;
        System.out.println(firstBadVersion(16));

        badVersion = 1456769280;
        System.out.println(firstBadVersion(1628653637));

        badVersion = 1150769282;
        System.out.println(firstBadVersion(1420736637));
    }
}
