package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：因为丑数都是由 2 3 5作为因子相乘的，所以求出以2 3 5为因子的数有哪些，并且从小到大排，找出第N个。
 *
 * 解题思路：以2 3 5各创建一个队列，每次从三个队列中找出最小的一个数，该数就是当前得到的最小的丑数，
 * 将这个数分别与 2 3 5相乘后放入对应的 2 3 5队列。
 * 因为 2 3 5为升序，用固定的数值去乘得的值默认也是升序的。能保持2 3 5三个队列各自有序。
 * 找出三个队列头部哪个为最小值，则为整体最小值。
 *
 * 注意：会存在不同队列有重复值的情况，当有重复值需要同时POLL（），去掉多余的重复值。
 *
 * 例如
 * ---------------------------
 *    结果集合：{1}
 *
 *     2队列：2
 *     3队列：3
 *     5队列：5
 *     ---------------------------
 *
 *     ---------------------------
 *  *  弹出2   并且与2 3 5相乘入队列
 *     结果集合：{1，2}
 *  *
 *  *     2队列：4
 *  *     3队列：3,6
 *  *     5队列：5,10
 *  *     ---------------------------
 *
 *   *  *  弹出3   并且与2 3 5相乘入队列
 *  *     结果集合：{1，2,3}
 *  *  *
 *  *  *     2队列：4,6
 *  *  *     3队列：6,9
 *  *  *     5队列：5,10,15
 *  *  *     ---------------------------
 */
public class GetUglyNumber_Solution {
    public static void main(String[] args) {
        GetUglyNumber_Solution g = new GetUglyNumber_Solution();
        int i = g.GetUglyNumber_Solution(7);
        System.out.println(i);
    }
    public int GetUglyNumber_Solution(int index) {
        if(index<6){
            return index;
        }
        int count = 1;
        int curNum = 0;
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();

        q2.add(2);
        q3.add(3);
        q5.add(5);

        while(count!=index){
            if(q2.peek()>q3.peek()){
                curNum = q3.peek()<q5.peek()?q3.poll():q5.poll();
            }else{
                curNum = q2.peek()<q5.peek()?q2.poll():q5.poll();
            }
            if(q2.peek()!=null && q2.peek().equals(curNum))q2.poll();
            if(q3.peek()!=null && q3.peek().equals(curNum))q3.poll();
            if(q5.peek()!=null && q5.peek().equals(curNum))q5.poll();



            q2.add(curNum*2);
            q3.add(curNum*3);
            q5.add(curNum*5);
            count++;
        }
        return curNum;

    }
}
