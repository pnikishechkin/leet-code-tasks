package ru.nikishechkin.leetcodetasks.t234_palindrome_linked_list;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        ListNode ln1 = new ListNode();
        ln1.val = 1;

        ListNode ln2 = new ListNode();
        ln2.val = 2;
        ln1.next = ln2;

        ListNode ln3 = new ListNode();
        ln3.val = 2;
        ln2.next = ln3;

        ListNode ln4 = new ListNode();
        ln4.val = 1;
        ln3.next = ln4;

        ListNode ln5 = new ListNode();
        ln5.val = 5;
        ln4.next = ln5;

        System.out.println(isPalindrome(ln1));
    }


    public static boolean isPalindrome(ListNode head) {

        // Создаем список из объектов
        ArrayList<ListNode> list = new ArrayList<ListNode>();

        do {
            list.add(head);
            head = head.next;
        } while (head != null);

        // Сравниваем попарно первый с последним, второй с предпоследним и т.д.
        for (int j = 0; j < list.size() / 2; j++) {
            if (list.get(j).val != list.get(list.size() - 1 - j).val) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome_v2(ListNode head) {

        // Определим количество элементов списка
        ListNode ln1 = head, ln2 = head;
        int count = 1;

        while (ln1.next != null) {
            ln1 = ln1.next;
            count++;
        }

        int c = count / 2;

        ln1 = head;
        ln2 = head;

        // Сравниваем попарно первый с последним, второй с предпоследним и т.д.
        for (int j = 0; j < c; j++) {

            for (int i = 1; i < count - (j * 2); i++) {
                ln2 = ln2.next;
            }

            if (ln1.val != ln2.val) {
                return false;
            }

            ln1 = ln1.next;
            ln2 = ln1;
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
