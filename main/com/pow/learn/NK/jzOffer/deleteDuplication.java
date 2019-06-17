package main.com.pow.learn.NK.jzOffer;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 *
 * 思路： 这里涉及到的，可能需要  改头节点 例如 1->1->1->5的情况下          5
 *                              改next指针的情况  1->2->3->3->3->4->4->4->5      1->2->5
 *
 *                              因为是有序的链表，可以顺序遍历链表
 *                              当head==重复部分时，head置空null
 *                              当走到下一个非重复部分的节点，这个节点设置为head
 *
 *                              另外用一个last指针，指向上一个非重复节点，负责把上一个非重复节点和当前非重复节点做连接
 *
 */
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p1 = pHead;
        ListNode last = pHead;
        ListNode head = pHead;
        while(p1!=null){
            while(p1!=null && p1.next!=null && p1.next.val ==p1.val){ //相同部分循环跳过
                if(head!=null && head.val ==p1.val){ //如果head不为空而且和重复部分相同，则置空
                    head = null;
                }
                p1 = p1.next;
            }

            //如果紧接着也是重复循环的话，continue，不走更改链表的部分的代码
            if(p1.next!=null && p1.next.next!=null && p1.next.val ==p1.next.next.val){
                p1 = p1.next;
                continue;
            }
            //下面是对头节点更改以及链表next指针修改的部分
            if(head==null){ //如果头节点为空，则把当前的非重复循环部分的值设置为head
                head = p1.next;
            }
            last.next = p1.next;  //last是最后走过的非重复节点
            last = p1.next;

            p1 = p1.next;
        }
        return head;
    }
}
