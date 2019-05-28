package main.com.pow.learn.NK.jzOffer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 思路：例:    4214
 *              对于千位： 4>1 所以该位置的1出现了 10的三次方次（1000-1999）
 *              对于百位： 因为千位为4，则百位实际上已经走过了4轮为1的情况。  为1的情况时会有（100-199）100个为1，即4×100个。
 *                         再看到百位上的数字为2 大于1 则已经走过多一轮(100-199) 则在 4×100的基础上再加100个。
 *              对于十位： 因为千位和百分为4和2，即 十位数已经经过了42轮为1的情况。   为1的情况时会有（10-19）10个为1，即42×10个。
 *                         再看到十位上的数字 等于 1，则证明还在10-19之间，还未完整走过一轮。则十位数后面的数个位，看到个位是4，则
 *                         当前十位数上面的1，已经走过了5次（10-14）.则十位数的1出现的总数为42×10+5。
 *              对于个位： 千位+百分+十位三个位的数即是个位出现的次数。若个位大于零，则再加1次。
 */

public class NumberOf1Between1AndN_Solution {
    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution n = new NumberOf1Between1AndN_Solution();
        int i = n.NumberOf1Between1AndN_Solution(1973);
        System.out.println(i);
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<10){
            return n>0?1:0;
        }
        char[] array = String.valueOf(n).toCharArray();
        int sum = 0;
        int gw =  Integer.parseInt(String.valueOf(array[array.length-1]));
        if(gw>0){
            sum++;
        }
        sum+=n/10;
        for(int i=0;i<array.length-1;i++){
            String store = new String(array,0,i);
            store = (store.equals(""))?"0":store;
            int afix = Integer.parseInt(store);  //这个是求当前位数之前的数的大小。如1234 .4的之前的数的大小为123
            int digit = array.length-i-1;
            digit = (int)Math.pow(10,digit);     //求出位数是多少。10 100 1000
            sum+=afix*digit;        //求该位数已经过了多少轮， 例如对于   1234    3的话就有12轮，      4的话就123轮。

            int curNum = Integer.parseInt(String.valueOf(array[i]));
            if(curNum==1){  //判断当前的数是否为1
                sum+=Integer.parseInt(new String(array,i+1,array.length-i-1))+1;
            }else if(curNum>1){ //当前的数是大于1的
                sum+=digit;
            }
        }
        return sum;
    }
}
