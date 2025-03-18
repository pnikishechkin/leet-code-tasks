package ru.nikishechkin.leetcodetasks.t135_candy;

import java.util.Arrays;

/**
 * 135. Candy
 *
 * В ряд стоят n детей. Каждому ребенку присваивается рейтинг, указанный в целочисленном массиве ratings.
 * Вы даете конфеты этим детям, соблюдая следующие требования:
 * У каждого ребенка должна быть хотя бы одна конфета.
 * Дети с более высоким рейтингом получают больше конфет, чем их соседи.
 * Верните минимальное количество конфет, которое вам нужно иметь, чтобы раздать конфеты детям.
 *
 * There are n children standing in a line. Each child is assigned a rating value given
 * in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
public class Solution {

    public static void main(String[] args) {
        int[] rat = {1, 0, 2}; // 5
        int[] rat2 = {1,2,87,87,87,2,1};
        // 0 1 1 0 0 -1 -2
        // 1 2 3 1 3  2  1
        // 1 2 3 1 3  2  1 - 13
        // если следующий больше, то забыли про левую часть
        // если следующий меньше, то смотрим еще дальше в массив, пока не встретим равный или больший и набираем
        // либо иначе сразу по числам
        System.out.println(candy(rat2));
    }

    public static int candy(int[] ratings) {

        // 1 0 2
        // 2 1 2 - 5

        // 1 2 2
        // 1 2 1 - 5

        //  Если рядом находится элемент больше, то брать на 1 больше, чем у него
        // сначала у всех 1

        int[] candies = new int[ratings.length];

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i + 1] + 1;
            }
            if (ratings[i] > ratings[i + 1]) {
                candies[i + 1] = candies[i] - 1;
            }
        }

        System.out.println(Arrays.toString(candies));
        return Arrays.stream(candies).sum();
    }
}
