package main.com.pow.learn.NK.jzOffer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路：用两个指针，快指针每次走两步，慢指针每次走一步，如果相遇的话，快指针回到起点。每次走一步
 * 慢指针每次走一步。相遇的地方就是入口
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null || pHead.next==null || pHead.next.next==null){
            return null;
        }
        ListNode p1 = pHead.next.next;
        ListNode p2 = pHead.next;
        while(p1!=p2){
            if(p1==null || p1.next==null){
                return null;
            }
            p1 = p1.next.next;
            p2 = p2.next;
        }
        p1 = pHead;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
