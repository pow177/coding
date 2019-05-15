package main.com.pow.learn.NK.jzOffer;
import java.util.*;
/**
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：把第N格所对应的所有跳法加起来就是该格子的跳法
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(target,1);
        int cur = target-1;
        while(cur!=-1){
            int sum = 0;
            int index = cur;
            while(index!=target){
                index++;
                sum+=map.get(index);
            }
            map.put(cur,sum);
            cur--;
        }
        return map.get(0);
    }
}
