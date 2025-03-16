package ru.nikishechkin.leetcodetasks.t125_valid_palindrome;

/**
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
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        String obr = s.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");
        System.out.println(obr);
        return true;
    }
}
