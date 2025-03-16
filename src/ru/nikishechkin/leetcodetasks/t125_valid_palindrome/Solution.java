package ru.nikishechkin.leetcodetasks.t125_valid_palindrome;

/**
 * 125. Valid palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Фраза является палиндромом, если после преобразования всех заглавных букв в строчные и удаления
 * всех небуквенно-цифровых символов она читается одинаково и вперед, и назад.
 * Буквенно-цифровые символы включают буквы и цифры.
 * Дана строка s, вернуть true, если это палиндром, или false в противном случае.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        // любой символ, кроме символьных
        String regex = "[^a-zA-Z\\d]";
        String obr = s.toLowerCase().replaceAll(regex, "");
        int i = 0;
        while (i < obr.length() / 2) {
            if (obr.charAt(i) != obr.charAt(obr.length() - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
