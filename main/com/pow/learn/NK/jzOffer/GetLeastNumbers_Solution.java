package main.com.pow.learn.NK.jzOffer;

import java.util.ArrayList;

/**
 *输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路：用桶排的方法，遍历找出前K个数。第一遍遍历找出最大值，然后生成对应的最大值桶。
 * 需要遍历 最大值×2次
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return new ArrayList<>();
        }
        if(input.length==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i:input){
            max = Math.max(max,i);
        }
        int[] array = new int[max+1];
        for(int i:input){
            array[i] = 1;
        }
        for(int i=0;i<array.length;i++){
            if(array[i]==1){
                list.add(i);
            }
            if(list.size()==k){
                break;
            }
        }
        return list;

    }
}
