package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 思路：用两个指针p1指向头，p2指向尾。aP1+aP2大于sum的时候，P2往左移动，当小于sum的时候P1往右移动。
 * 第一组找到等于sum的两个数则为最小乘积的。因为 a+b=sum   当a和b的差值越大的话。乘积就越小。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int p1 = 0;
        int p2 = array.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        while(p1<array.length-1 &&p1<p2){
            int num = array[p1]+array[p2];
            if(num==sum){
                result.add(array[p1]);
                result.add(array[p2]);
                return result;
            }else if(num>sum){
                while(array[p1]+array[p2]>sum)p2--;
            }else{
                while(array[p1]+array[p2]<sum)p1++;
            }
        }
        return result;

    }
}
