package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 这里注意如果将n左移去算的话，为负数的时候，最高位的符号位是不会右移的
 * 所以这里用一个在最后边的一个数1，依次往左移一位，判断n每个位置是不是为1
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        int m = 1;
        int result = 0;
        while(m!=0){
            if((n&m)!=0){
                result++;
            }
            m = m<<1;
        }
        return result;
    }
}
