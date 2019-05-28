package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * 思路：用有序的 HashMap LinkedHashMap保证了顺序，然后扫一遍数组后。让出现2次的设置为-1，出现一次的则设置i位置的值。
 * 然后遍历LinkedHashMap的时候返回第一个非-1的就是第一个只有一个的数字
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        FirstNotRepeatingChar f = new FirstNotRepeatingChar();
        int i = f.FirstNotRepeatingChar("googgle");
        System.out.println(i);
    }
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] array = str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],-1);
            }else{
                map.put(array[i],i);
            }
        }
        for(Integer i:map.values()){
            if(i!=-1){
                return i;
            }
        }
        return -1;
    }
}
