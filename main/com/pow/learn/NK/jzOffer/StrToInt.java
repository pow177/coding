package main.com.pow.learn.NK.jzOffer;

/**
 * 将一个字符串转换成一个整数
 * (实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 *
 * 思路：用 char-'0'的方式替换掉switch也可以。
 */
public class StrToInt {
    public static void main(String[] args) {
        StrToInt st = new StrToInt();
        st.StrToInt("+2147483647");
    }
    public int StrToInt(String str) {
        if(str.equals("")){
            return 0;
        }
        char[] array = str.toCharArray();
        int index = 0;
        int symb = 1;
        long w = (int)Math.pow(10,str.length()-1);  //注意用long 因为怕int不够位数存
        long sum = 0;
        if(array[0]=='-'){
            symb = -1;
            index++;
            w/=10;
        }else if(array[0]=='+'){
            index++;
            w/=10;
        }
        else if(array[0]<'0' || array[0]>'9'){
            return 0;
        }

        while(index<str.length()){
            switch(array[index++]){
                case '0': w/=10;break;
                case '1': sum+=w*1;w/=10;break;
                case '2': sum+=w*2;w/=10;break;
                case '3': sum+=w*3;w/=10;break;
                case '4': sum+=w*4;w/=10;break;
                case '5': sum+=w*5;w/=10;break;
                case '6': sum+=w*6;w/=10;break;
                case '7': sum+=w*7;w/=10;break;
                case '8': sum+=w*8;w/=10;break;
                case '9': sum+=w*9;w/=10;break;
                default:return 0;
            }
        }
        return (int)(symb*sum);
    }
}
