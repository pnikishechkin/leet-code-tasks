package ru.nikishechkin.leetcodetasks.t13_roman_to_integer;

/**
 * 13. Roman to integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four
 * is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it
 * making four. The same principle applies to the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt_v2("III"));
        System.out.println(romanToInt_v2("IV"));
        System.out.println(romanToInt_v2("VI"));
        System.out.println(romanToInt_v2("XC"));
        System.out.println(romanToInt_v2("CXCIX"));
    }

    public static int romanToInt(String s) {

        int val[] = new int[s.length()];

        // Переводим каждый символ в число
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    val[i] = 1;
                    break;
                case 'V':
                    val[i] = 5;
                    break;
                case 'X':
                    val[i] = 10;
                    break;
                case 'L':
                    val[i] = 50;
                    break;
                case 'C':
                    val[i] = 100;
                    break;
                case 'D':
                    val[i] = 500;
                    break;
                case 'M':
                    val[i] = 1000;
                    break;
            }
        }

        int res = 0;

        // Проходимся по всем числам, если идут на уменьшение - суммировать к текущему результату.
        // Если следующее число после текущего больше, то рассчитываем как разность "следующее-текущее"
        for (int i = 0; i < val.length; i++) {
            if (i != val.length - 1) {
                if (val[i + 1] <= val[i]) {
                    res += val[i];
                } else {
                    res += val[i + 1] - val[i];
                    i++;
                }
            } else {
                res += val[i];
            }
        }

        return res;
    }

    public static int romanToInt_v2(String s) {

        int cur = 0, next = 0, res = 0;
        boolean needGetCur = false;

        // Переводим каждый символ в число
        for (int i = 0; i < s.length(); i++) {

            // Если первый или флаг установлен, то находим текущий вручную
            if (i == 0 || needGetCur) {
                cur = getValFromChar(s.charAt(i));
            } else {
                // Если не первый, то текущий берем ранее рассчитанного следующего
                cur = next;
            }

            // Если не последний символ
            if (i != s.length() - 1) {

                // Значение следующего
                next = getValFromChar(s.charAt(i + 1));

                if (next <= cur) {
                    res += cur;
                    needGetCur = false;
                } else {
                    res += next - cur;
                    needGetCur = true;
                    i++;
                }

            } else {
                res += cur;
            }
        }

        return res;
    }

    public static int getValFromChar(char c) {

        int res;

        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                res = 0;
                break;
        }

        return res;
    }
}
