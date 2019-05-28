package main.com.pow.learn.NK.jzOffer;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 思路：两种情况
 * 1.当集合中存在正数时候的逻辑：判断当前位置的数是否是正数，正数的话往后累积，并且累积一个位置的时候如果大于最大值则更新最大值。
 * 当累积到某个位置sum小于0的话，那就没有比较继续往后走了。（因为当前累积为负数再往后面的话，只可能会让后面的值变小）
 *
 * 2.当集合中存在的数全都是负数的时候，返回最大的一个负数就好了。
 *
 * 代码里我是每次的位置都判断正负，负的则记录负的最大值。正数则走逻辑1的程序
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int p = 0;
        int max = 0;
        int maxOnNe = array[0]; //给个初始值 INTEGER.MIN_VALUE也可以，感觉有点大
        while(p<array.length){
            if(array[p]>0){        //有正数的时候的逻辑
                int sum = 0;
                for(int i=p;i<array.length;i++){
                    sum+=array[i];
                    if(sum<0) break;
                    max = Math.max(sum,max);
                }

            }else{ //若为负数走选负数中最大的逻辑
                maxOnNe = Math.max(maxOnNe,array[p]);
            }
            p++;
        }
        return max==0?maxOnNe:max;
    }
}
