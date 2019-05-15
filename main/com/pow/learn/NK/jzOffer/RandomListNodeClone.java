package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路:原来链表 1->2->3
 * 1.添加复制节点 1->1'->2->2'->3->3'
 * 2.为添加的复制节点添加random指针。复制节点的上一节点的random节点的下一节点（例如1的random = 3,那么random.next = 3'，刚好指向复制的3'节点)；
 * 3.节点拆分，因为复制链表需要不破坏原来的链表结构，并且返回一个新克隆的链表。
 * 节点拆分：奇数节点相连接，偶数节点相连接。
 */
public class RandomListNodeClone {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode n1 = new RandomListNode(2);
        RandomListNode n2 = new RandomListNode(3);

        head.next = n1;
        n1.next = n2;

        n1.random = n2;
        n2.random = n1;

        System.out.println(new RandomListNodeClone().Clone(head));
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode run = pHead;
        RandomListNode cur = null;
        while(run!=null){
            cur = new RandomListNode(run.label);
            cur.next = run.next;
            run.next = cur;
            run = cur.next;
        }
        run = pHead;
        while(run!=null){
            if(run.random!=null){
                run.next.random = run.random.next;
            }
            run = run.next.next;
        }
        RandomListNode newNode = pHead.next;
        cur = pHead;
        run = newNode;
        while(true){
            if(run.next==null){
                break;
            }
            cur.next = cur.next.next;
            run.next = run.next.next;
            cur = cur.next;
            run = run.next;
        }
        cur.next  = null;
        return newNode;
    }

   static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}


