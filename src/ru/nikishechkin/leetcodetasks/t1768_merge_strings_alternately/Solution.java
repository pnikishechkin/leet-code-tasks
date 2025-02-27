package ru.nikishechkin.leetcodetasks.t1768_merge_strings_alternately;

/**
 * 1768. Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged
 * string.
 * <p>
 * Вам даны две строки word1 и word2. Объедините строки, добавляя буквы в чередующемся порядке, начиная с word1. Если
 * строка длиннее другой, добавьте дополнительные буквы в конец объединенной строки.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "12345"));
    }

    public static String mergeAlternately(String word1, String word2) {

        char[] merge = new char[word1.length() + word2.length()];
        int min = word1.length() < word2.length() ? word1.length() : word2.length();

        for (int i = 0; i < min; i++) {
            merge[i * 2] = word1.charAt(i);
        }
        for (int i = 0; i < min; i++) {
            merge[i * 2 + 1] = word2.charAt(i);
        }

        if (word1.length() > word2.length()) {
            for (int i = min; i < word1.length(); i++) {
                merge[min + i] = word1.charAt(i);
            }
        } else {
            for (int i = min; i < word2.length(); i++) {
                merge[min + i] = word2.charAt(i);
            }
        }

        String res = String.valueOf(merge);
        return res;
    }
}
