package main.com.pow.learn.NK.jzOffer;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 *
 * 思路：将字符串进行反转就行了。因为单词之间会用空格隔开。所以用空格去分割字符串。
 * 然后0跟length-1调换，1跟length-2调换，依次交换完毕后重新遍历拼接起来
 *
 * （好像分割完直接从最后一个位置直接遍历拼接也可以得到结果，少了swap的步骤）
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str.trim().equals(""))return str;
        String[] array = str.split(" ");
        for(int i=0,j=array.length-1;i<j;i++,j--){
            swap(i,j,array);
        }
        StringBuffer sbf = new StringBuffer();
        for(String s:array){
            sbf.append(s+" ");
        }
        sbf.deleteCharAt(sbf.length()-1);
        return sbf.toString();
    }

    public void swap(int i,int j,String[] array){
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
