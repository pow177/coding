package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
 * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决
 * 定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”
 * (大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 *
 * 思路:例如 1235，就缺一个0可以去代替4.
 *
 * 对数组进行排序。然后遍历数组，统计0出现的次数，即可变数字的个数。然后从非零的位置开始到最后，计算后一个数和前一个数之间缺少的数的数量。
 * 当可变数字大于缺少的数字则可以凑成顺子。
 */
public class isContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0){
            return false;
        }
        int need = 0;
        int s = 0;
        int lz = 0;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                lz++;
                s++;
            }else if(i!=0 && numbers[i]==numbers[i-1]){
                return false;
            }
            else if(i!=0 && numbers[i]!=0 &&numbers[i-1]!=0){
                need+=numbers[i]-numbers[i-1]-1;
            }
        }
        if(numbers[numbers.length-1]==numbers[numbers.length-2]){
            return false;
        }
        int lastShort = Math.min(numbers[numbers.length-1]-numbers[numbers.length-2]-1,
                numbers[s]-(numbers[numbers.length-1]-13)-1);
        need+=lastShort;
        if(need<=lz){
            return true;
        }
        return false;
    }
}
