package main.com.pow.learn.NK.jzOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 0 1 1 2 3 5 8 13......
 * 用两个数字表示上一个数，和上上一个数
 * 求出第n个为止，将这两个数相加即可
 *
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        int last = 1;
        int lastOflast = 0;
        int result = 0;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        for(int i=2;i<n;i++){
            int next = last+lastOflast;
            lastOflast = last;
            last = next;
        }
        result = last+lastOflast;
        return result;
    }
}
