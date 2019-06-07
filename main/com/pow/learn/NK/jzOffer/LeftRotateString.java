package main.com.pow.learn.NK.jzOffer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令
 * 的运算结果。对于一个给定的字符序列S，请你把
 * 其循环左移K位后的序列输出。例如，字符序列
 * S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 *
 *
 * 思路：例如 abcdefgh 左移3位，则是把abc放到defgh的后面。
 *
 * 可以将字符串分成 abc defgh两部分去反转。变成 cba hgfed，
 * 再将两部分看成一个整体一起反转。得到defghabc得到左移的目的。
 *
 * 因为把第一部分的头部转到了第二部分的尾部，然后再整体一转就变成了这种效果。
 *
 *
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str.equals(""))return "";
        //abcdefgh  n=3
        char[] array = str.toCharArray();

        //abc defgh ->  cba defgh
        for(int i=0,j=n-1;i<j;i++,j--){
            swap(i,j,array);
        }
        //cba defgh -> cba hgfed
        for(int i=n,j=array.length-1;i<j;i++,j--){
            swap(i,j,array);
        }
        //cbdhgfed ->defghabc
        for(int i=0,j=array.length-1;i<j;i++,j--){
            swap(i,j,array);
        }
        return String.valueOf(array);
    }

    public void swap(int i,int j,char[] array){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
