package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 用stack太慢了，pop的时候，需要remove最顶的元素，底层remove方法是重新copy一份新的array。
 * ArrayList的话很快，查询和add基本都是一个index移动而已。
 */
public class PrintListFromTailToHead {

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

            ListNode head = listNode;
            ArrayList<Integer> list = new ArrayList<>();
            new Stack<Integer>().add(1);
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;


            }
            Collections.reverse(list);
            return list;
        }

        public static class ListNode {
            int val;
            ListNode next;
        }
}
