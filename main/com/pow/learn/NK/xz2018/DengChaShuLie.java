package main.com.pow.learn.NK.xz2018;
import java.util.*;
/**
 * 如果一个数列S满足对于所有的合法的i,
 * 都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。
 * 小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。
 * 但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 *
 *
 *
 * 输入描述:
 * 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 * 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。
 * 输出描述:
 * 如果可以变成等差数列输出"Possible",否则输出"Impossible"。
 * 示例1
 * 输入

 * 3
 * 3 1 2
 * 输出

 * Possible
 *
 *
 * 思路：找出最大值和最小值，用等差数列公式（a1+an)n/2与数组累积和对比，看是否相等则可以判断是否能构成等差数列
 */
public class DengChaShuLie {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        float max = -1.0f;
        float min = 10001.0f;
        int sum = 0;
        for(String s:str){
            int cur = Integer.parseInt(s);
            max = Math.max(max,cur);
            min = Math.min(min,cur);
            sum+=cur;
        }

        String result = sum==(min+max)*n/2?"Possible":"Impossible";
        System.out.println(result);
    }
}
