package main.com.pow.learn.NK.jzOffer;
import java.util.*;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 * （先后次序不同算不同的结果）。
 *
 *
 * 思路：前面的台阶的跳法种类由后面的台阶种类决定。
 * 每个台阶可以有两种选择，跳一步，或者跳两步。
 * 即第i-2的台阶，等于第i-1加第i个台阶的跳法相加。
 * 类推到0为止，即可获得总的跳法。
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(target,1);
        int i = target-1;
        while(i!=-1){
            int c1 = i+1;
            int c2 = i+2;

            int count = 0;
            if(c1<=target){
                count += map.get(c1);
            }
            if(c2<=target){
                count+=map.get(c2);
            }
            map.put(i,count);
            i--;
        }
        return map.get(0);
    }
}
