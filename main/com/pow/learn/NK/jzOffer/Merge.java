package main.com.pow.learn.NK.jzOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：像是归并排序那样的玩法。谁先谁先排。
 * (要注意list1和list2为空的时候的处理。以及找出一个head来继续后续next操作。）
 * (注意是用当前节点的next指向一个新的节点，而不是直接把指针指向当前节点的next节点再去赋值。这样会丢失节点之间的关系指向）
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null;
        ListNode left = list1;
        ListNode right = list2;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(left.val<=right.val){
            head = new ListNode(left.val);
            left = left.next;
        }else{
            head = new ListNode(right.val);
            right = right.next;
        }
        ListNode cur = head;


        while(left!=null && right!=null){
            if(left.val>=right.val){
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
            else{
                cur.next = left;
                cur = cur.next;
                left = left.next;
            }
        }
        while(left!=null){
            cur.next = left;
            cur = cur.next;
            left = left.next;
        }

        while(right!=null){
            cur.next = right;
            cur = cur.next;
            right = right.next;
        }

        return head;
    }

}
