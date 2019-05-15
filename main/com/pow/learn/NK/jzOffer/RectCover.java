package main.com.pow.learn.NK.jzOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 例子：n=3的时候 f(3) = f(1)+f(2)
 * 第n个位置横放的时候，只剩下 1个格子的位置，该位置只能竖着放。f(1)
 * 第n个位置竖着放的时候，剩下 2个格子的位置，可以竖着放两个，或者横着放即f(2)时候那么多
 * 所以第n个位置共有f(n)= f(1)+(f2)个情况种
 */
import java.util.*;
public class RectCover {

    public int RectCover(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(0,1);
        int cur = 1;
        while(cur<=target){
            cur++;
            int c1 = cur-1;
            int r1 = map.get(c1);
            int c2 = cur-2;
            int r2 = map.get(c2);
            map.put(cur,r1+r2);
        }
        return map.get(target);
    }
}
