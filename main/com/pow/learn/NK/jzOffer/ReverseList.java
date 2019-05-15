package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode p3 = null;
        //头节点为null返回null
        if(p1==null){
            return null;
        }
        p2 = p1.next;
        //第二个节点为null，则直接返回第一个节点
        if(p2==null){
            return p1;
        }
        //下面就是节点大于2个时候的处理逻辑。用3个指针
        p3 = p2.next;
        head.next = null;
        while(true){
            p2.next = p1;
            if(p3==null){
                break;
            }
            p1 = p2;
            p2 = p3;

            p3 = p3.next;
        }
        return p2;
    }
}
