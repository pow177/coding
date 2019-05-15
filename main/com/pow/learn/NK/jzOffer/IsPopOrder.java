package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5
 * 是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public static void main(String[] args){

    }

    /**
     * 思路：根据popA的第一个数可以知道，前面压了多少个数。例如题目压了4，那么前面的1，2，3肯定已经压入了，所以index指向3.
     * popA后续过程中，若在出现3之前提前出现了比index索引小的数（1，2），则不满足栈的特性。当3出了之后，index指向2,
     * 2出了之后指向1
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<pushA.length;i++){
            map.put(pushA[i],i);
        }
        Integer index = map.get(popA[0]);
        if(index==null){  //若空则存在不相同的数，返回false
            return false;
        }
        index--;
        for(int i=0;i<popA.length;i++){
            Integer curIndex = map.get(popA[i]);
            if(curIndex==null){//若空则存在不相同的数，返回false
                return false;
            }

            if(curIndex<index){
                return false;
            }
            if(index==curIndex){
                index = index-1;
            }

        }
        return true;
    }
}
