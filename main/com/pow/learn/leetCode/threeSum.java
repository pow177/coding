package main.com.pow.learn.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class threeSum {
    public static void main(String[] args){
        threeSum t = new threeSum();
        int[] nums = {0,0,0};
        t.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return list;
        }
          process(list,nums,0,new ArrayList<Integer>(),0,new HashSet<Integer>());
        return list;
    }

    public static void process(List<List<Integer>> list, int[] nums, int c, List<Integer> collet, int index, Set<Integer> set){
         if(c==3 || index==nums.length){
             if(collet.size()==3) {

                 int result = collet.get(0) + collet.get(1) + collet.get(2);
                 if (result == 0) {
                     int cheRep = 0;
                     if(collet.get(0)<0){
                         cheRep+=collet.get(0);
                     }
                     if(collet.get(1)<0){
                         cheRep+=collet.get(1);
                     }
                     if(collet.get(2)<0){
                         cheRep+=collet.get(2);
                     }
                     if(!set.contains(cheRep)) {
                         List<Integer> copy = new ArrayList<Integer>();
                         copy.addAll(collet);
                         list.add(copy);
                         set.add(cheRep);
                     }
                 }
             }
             return;
         }
         collet.add(nums[index]);
         process(list,nums,c+1,collet,index+1,set);
         collet.remove(new Integer(nums[index]));
        process(list,nums,c,collet,index+1,set);
    }
}
