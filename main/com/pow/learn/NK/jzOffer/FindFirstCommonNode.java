package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 思路1（代码）:遍历一次链表1，把节点都存在Set里面，然后遍历一遍链表二，看是否有在Set出现的值，有的话则返回该节点。
 *
 * 思路2： 遍历一遍 链表1和链表2。找出他们两个长度，然后用长的减短的得出两个链表相差的长度L。长的链表先走L。
 * 然后两个链表再一起同时走。若出现相等，则为相交的节点
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<Integer> set = new HashSet<>();
        while(pHead1!=null){
            set.add(pHead1.val);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            if(set.contains(pHead2.val)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}
