package main.com.pow.learn.NK.jzOffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 *
 * 思路：等差数列前N项和
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        return (1+n)*n/2;
    }
}
