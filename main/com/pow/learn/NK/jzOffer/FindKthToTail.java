package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：用两个指针，第一个指针先走k个节点的距离，然后第二个指针指向第一个指针
 * 那么两个指针之间的距离为k-1，第一个指针指的就是倒数第k的位置。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k==0 || head==null){
            return null;
        }
        ListNode p1 = head;
        int c = 1;
        while(head.next!=null){
            if(c>=k){
                p1 = p1.next;
            }
            c++;
            head = head.next;
        }
        if(c<k){
            return null;
        }
        return p1;
    }
}
