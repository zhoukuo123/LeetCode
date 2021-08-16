package 链表;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] ints = new int[arr.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(arr[i]);
        }


    }

    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return null;
//        }
//
//        ListNode newHead = new ListNode(0);
//        ListNode newTail = newHead;
//        while (head != null) {
//            if (head.val != val) {
//                newTail.next = head;
//                newTail = head;
//            }
//            head = head.next;
//        }
//        newTail.next = null;
//        return newHead.next;


        Scanner cin = new Scanner(System.in);
        int r = cin.nextInt();
        int c = cin.nextInt();
        int[][] matrix = new int[r][c];
        cin.nextLine(); // 跳过行数和列数后的换行符
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = cin.nextInt();
            }
        }


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }


        }


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int n2 = sc.nextInt();
        }


        // 时间复杂度O(n)
        // 空间复杂度O(1)
        // 添加虚拟头结点
        // head用来扫描链表节点
        // newHead是新链表的头结点
        // newTail是新链表的最后一个节点
        // 认为是在构建一个新的链表
        if (head == null) {
            return null;
        }

        // 虚拟头节点
        ListNode newHead = new ListNode(0); // 虚拟头结点, 值随便
        ListNode newTail = newHead;

        while (head != null) {
            if (head.val != val) {
                // 将head拼接到newTail的后面
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next; // 返回虚拟头节点的next
    }

    public ListNode removeElements2(ListNode head, int val) {
        // 时间复杂度O(n)
        // 未添加虚拟头结点
        // 新链表的头结点
        ListNode newHead = null;
        // 新链表的尾结点
        ListNode newTail = null;

        while (head != null) {
            if (head.val != val) {
                if (newTail == null) {
                    newHead = newTail = head;
                } else {
                    newTail.next = head;
                    newTail = head;
                }
            }
            head = head.next;
        }
        if (newTail == null) {
            return null;
        } else {
            newTail.next = null;
        }
        return newHead;
    }

    public ListNode removeElements3(ListNode head, int val) {
        // O(n)
        if (head == null) return null;
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        ListNode headNode = head;

        while (headNode.next != null) {
            if (headNode.next.val == val) {
                headNode.next = headNode.next.next;
            } else {
                headNode = headNode.next;
            }
        }
        return head;
    }
}
