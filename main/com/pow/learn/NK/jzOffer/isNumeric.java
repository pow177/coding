package main.com.pow.learn.NK.jzOffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 *
 * 思路：分成了 e/E 出现前和出现后
 *
 * 出现前：  0位置可以为+ - ，    .只能出现一次
 * 出现后：  e后面的位置可以是+ -，   .不可以出现
 *           e不能是最后一个位置
 */
public class isNumeric {
    public boolean isNumeric(char[] str) {
        boolean poitFlag = false;
        boolean eFlag = false;
        int eIndex = -1;
        for(int i=0;i<str.length;i++){
            if(!eFlag && str[i]=='e'||str[i]=='E'){
                if(i==str.length-1){  // e是最后一个数 返回false
                    return false;
                }
                eIndex = i;
                eFlag = true;
                continue;
            }
            if(eFlag && (str[i]=='E' || str[i]=='e')){ //已经出现过e，如果再出现一次则为false
                return false;
            }
            if(eFlag){  //出现过e后的情况
                if(i==eIndex+1 && (str[i]=='+' || str[i]=='-')){
                    continue;
                }
                if(str[i]<='9' && '0'<=str[i]){
                    continue;
                }
                return false;
            }else{ //未出现过e的情况
                if(i==0 && (str[i]=='+' || str[i]=='-')){  //第一个位置可以为+ -
                    continue;
                }
                if(str[i]<='9' && '0'<=str[i]){
                    continue;
                }
                if(!poitFlag && str[i]=='.'){   //还未出现过 点，如果出现过只能出现一次
                    poitFlag = true;
                    continue;
                }
                return false;
            }

        }
        return true;
    }
}
