package main.com.pow.learn.NK.xz2018;

/**
 * 小易为了向他的父母表现他已经长大独立了,
 * 他决定搬出去自己居住一段时间。一个人生活增加了许多花费:
 * 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 * 当前小易手中已经有f个水果和d元钱,
 * 小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,
 * 小易希望你来帮他计算一下他最多能独立生活多少天。
 *
 *
 * 输入描述:
 * 输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 * 输出描述:
 * 输出一个整数, 表示小易最多能独立生活多少天。
 *
 * 输入
 * 3 5 100 10
 *
 * 输出
 * 11
 *
 * 思路:  分了两种情况，一种是自带的水果数量，在把钱全花在住房的情况下还多，直接返回钱/租金得到的天数
 *
 * 另外一种是，自带的水果的数量少于把钱全给房租的情况下。这样就可以把自带水果的钱直接换算成钱，加到总额
 * 用总额/每天水果的钱+每天租房的钱。  用水果换算的钱就像是补贴一样，这部分花完就会和房租的钱一起扣。
 */
import java.util.*;
public class DuLiDeXiaoYi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        long allLive = Long.parseLong(data[2])/Long.parseLong(data[0]);
        if(allLive<=Long.parseLong(data[1])){
            System.out.print(Long.parseLong(data[2])/Long.parseLong(data[0]));
            return;
        }
        long  sum = Long.parseLong(data[1])*Long.parseLong(data[3])+Long.parseLong(data[2]);
        long result = sum/(Long.parseLong(data[0])+Long.parseLong(data[3]));
        System.out.print(result);
    }
}
