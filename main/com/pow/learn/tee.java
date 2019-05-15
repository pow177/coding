package main.com.pow.learn;

public class tee {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int[] lightTime = new int[3];
//        String[] temStr = sc.nextLine().split(" ");
//        lightTime[0] = Integer.parseInt(temStr[0]);
//        lightTime[1] = Integer.parseInt(temStr[1]);
//        lightTime[2] = Integer.parseInt(temStr[2]);
//
//        int roadNum = Integer.parseInt(sc.nextLine());
//        System.out.println(roadNum);
//        int[][] road = new int[roadNum][2];
//
//        int count = 0;
//        for (int i = 0; i < roadNum; i++) {
//            temStr = sc.nextLine().split(" ");
//            road[i][0] = Integer.parseInt(temStr[0]);
//            road[i][1] = Integer.parseInt(temStr[1]);
//
//            switch (road[i][0]) {
//                case 0:
//                    count += road[i][1];
//                    break;
//                case 1:
//                    count += road[i][1];
//                    break;
//                case 2:
//                    count += road[i][1] + lightTime[0];
//                    break;
//            }
//
//        }
//        System.out.println(count);

        tee t = new tee();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        l4.next = l5;
        l5.next = l6;
        t.Merge(l1,l4);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null;
        ListNode left = list1;
        ListNode right = list2;
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
            else {
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

     static  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
