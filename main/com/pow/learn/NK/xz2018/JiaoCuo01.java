package main.com.pow.learn.NK.xz2018;
import java.util.*;

/**
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。
 * 例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。
 * 小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 *
 *
 * 思路:遍历每个字符，看上一个字符是否跟当前字符相同，
 * 不相同计数器+1.每次计数器有变化的时候就更新最大值。
 * 当出现上一个字符和当前字符相同的时候，计数器重置0
 */
public class JiaoCuo01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char last = str.charAt(0);  //给0位置的值
        int max = 1;
        int runCount = 0;
        for(int i=1;i<str.length();i++){
            char cur = str.charAt(i);
            if(last!=cur){
                runCount++;
                max = Math.max(max,runCount+1); //因为会算少一个，所以补1
                last = cur;
                continue;
            }
            last = cur;
            runCount = 0;

        }
        System.out.print(max);
    }
}
