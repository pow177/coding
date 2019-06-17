package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 *
 * 思路：刚开始用异或做，发现会有问题，就是虽然之前没出现过，但是之前字符的异或结果刚好和最后一个字符一样，那结果就会有错误
 *
 * 新的思路就用list保证字符插入的顺序性，用HashMap统计字符的出现次数。
 * 空间2N，时间N
 */
public class FirstAppearingOnce {
    ArrayList<Character> arrayList = new ArrayList<>();
    HashMap<Character,Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(!map.containsKey(ch)){
            map.put(ch,1);
        }else{
            map.put(ch,map.get(ch)+1);
        }
        arrayList.add(ch);

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for(char ch:arrayList){
            if(map.get(ch)==1){
                return ch;
            }
        }
        return '#';
    }
}
