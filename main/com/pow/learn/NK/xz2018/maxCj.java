package main.com.pow.learn.NK.xz2018;
import java.util.*;
public class maxCj {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();  //跳过第一个数字
        String[] array = sc.nextLine().split(" ");
        long max = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        long min = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for(int i=0;i<array.length;i++){

            long cur = Long.parseLong(array[i]);
            if(cur==0){
                continue;
            }
            if(max<cur){
                max3 = max2;
                max2 = max;
                max = cur;
            }else if(cur>max2 && cur<max){
                max3 = max2;
                max2 = cur;
            }else if(cur>max3 && cur<max2){
                max3 = cur;
            }

            if(cur<min){
                min2 = min;
                min = cur;
            }else if(cur<min2 && cur>min){
                min2 = cur;
            }
        }
        long result = Math.max(max*max2*max3,min*min2*max);
        System.out.println(result);
    }
}
