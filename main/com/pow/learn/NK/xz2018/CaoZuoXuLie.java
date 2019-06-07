package main.com.pow.learn.NK.xz2018;

/**
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 *
 * 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
 *
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 *
 * 输入
 * 4
 * 1 2 3 4
 *
 * 输出
 * 4 2 1 3
 *
 *
 * 思路:根据规律，奇数的时候， 1 2 3 4 5 是  5 3 1 2 4.即从最后一个开始算的所有奇数项加上正着算的偶数项
 *
 * 偶数的时候：1 2 3 4 5 6 是 6 4 2 1 3 5  即从最后一个开始算的所有偶数项，加上正着算的奇数项
 */
import java.util.*;
public class CaoZuoXuLie {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        StringBuffer sbf = new StringBuffer();
        if(n%2==0){
            for(int i=strs.length-1;i>=0;i-=2){
                sbf.append(strs[i]+" ");
            }
            for(int i=0;i<strs.length;i+=2){
                sbf.append(strs[i]+" ");
            }
        }else{
            for(int i=strs.length-1;i>=0;i-=2){
                sbf.append(strs[i]+" ");
            }
            for(int i=1;i<strs.length;i+=2){
                sbf.append(strs[i]+" ");
            }
        }
        System.out.print(sbf.toString().trim());
    }
}
