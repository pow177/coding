package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：将int数组排序。排序完之后，按顺序遍历，比较ab ba的组合哪个小，哪个小取哪个
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0){
            return "";
        }
        Arrays.sort(numbers);
        String lastResult = numbers[0]+"";
        for(int i=1;i<numbers.length;i++){

            int b = numbers[i];

            long t1 = Long.parseLong(lastResult+String.valueOf(b));
            long t2 = Long.parseLong(String.valueOf(b)+lastResult);

            lastResult = t1<t2?String.valueOf(t1):String.valueOf(t2);
        }
        return lastResult;
    }
}
