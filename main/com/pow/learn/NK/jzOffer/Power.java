package main.com.pow.learn.NK.jzOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 思路：要考虑expoent 小于零，大于零，等于零三种情况
 */
public class Power {
    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1.0d;
        }
        double result = base;
        if(exponent>0){
            for(int i=0;i<exponent-1;i++){
                result *= base;
            }
        }else{
            exponent = -exponent;
            for(int i=0;i<exponent-1;i++){
                result *= base;
            }
            result = 1.0d/result;
        }
        return result;
    }
}
