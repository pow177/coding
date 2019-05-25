package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：利用TreeSet对所有的排列情况下的字符串进行一个字典排序，我们只需要把所有的排列可能的字符串都列出来即可。
 * 排列的思路：
 *        》一个字符串N个字符，从左往右，第一个字符有N种选择，第二个字符有N-1种选择，第三个字符有N-2种选择.....《
 * 而且   》第一个位置的选择项会影响后面的可选项《
 * 用for+递归可以实现这种场景 ：
 *
 * 例子： abc
 *             0位置有：a b c三种选择
 *             0位置选了b的话 1位置就有 a c两个选择
 *             0位置选了c的话 1位置就有 a b两个选择
 *
 *
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        if(str.length()==0){
            return new ArrayList<String>();
        }
        char[] array = str.toCharArray();
        process(array,0);
        return new ArrayList<String>(tree);
    }

    TreeSet<String> tree = new TreeSet<>();      //TreeSet是有序的，帮我们做好了字典序的排序

    public void process(char[] str,int curIndex){
        if(curIndex==str.length-1){
            tree.add(String.valueOf(str));
        }
        for(int i=curIndex;i<str.length;i++){
            if(curIndex!=i && str[curIndex]==str[i]){
                continue;       //跳过相同字符的，否则会有重复的字符串
            }
            swap(curIndex,i,str);
            process(str,curIndex+1);
            swap(curIndex,i,str);   //换回来
        }
    }

    public void swap(int i,int j,char[] array){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
