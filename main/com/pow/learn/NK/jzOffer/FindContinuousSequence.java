package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *
 * 思路:用L和R表示窗口的范围  因为是等差数列。可以用公式直接算得窗口范围内的值大小，若等于sum则加入list
 *
 * 当窗口范围内的值大的话，则左界限向右移动，右界限不动。
 * 若值较小，左界限不动，右界限往右移动。
 *
 * 以某个值为左界限，右界限不断扩大，直到出现大于目标值的情况，则在窗口范围内有可能存在连续相加等于目标值的情况。
 * 这时候左边界依次往右移动，每次都判断是否等于目标值，直到移动到窗口内的值之和小于目标值时可以确认是没有。
 *
 * （厉害的地方是避免的类似传统的从某一个位置开始，累积算到超过目标值，然后next，又继续算，避免了大量的重复计算）
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int L = 1;
        int R = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(L<R){
            int num = ((R+L)*(R-L+1))/2;
            if(num==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=L;i<=R;i++){
                    list.add(i);
                }
                result.add(list);
                L++;
            }else if(num>sum){
                L++;
            }else{
                R++;
            }
        }
        return result;
    }
}
