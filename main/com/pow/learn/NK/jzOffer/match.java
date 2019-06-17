package main.com.pow.learn.NK.jzOffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 *
 *
 * 思路：难点主要是在 * 匹配任意多个。这里分两种情况
 *
 * 情况1：pattern当前字符后面有* 和pattern当前字符后面没有*。
 *
 * 通过递归的方式，可以当前选择匹配pattern的当前字符fi+1,si不变，也可以选择fi不变，si+2跳过当前的  字符*
 *
 * base case：当pattern走完了，字符串str还没走完，则返回false;
 *
 *            当字符串str和pattern都走完了，那就返回true
 *
 *            当字符串str走完了，pattern还需要看情况，分带*和不带*，带*的需要继续往下si+2去匹配看看。不带*的则判断是否相等
 */
public class match {
    public boolean match(char[] str, char[] pattern)
    {
        return process(str,pattern,0,0);
    }

    public boolean process(char[] str,char[] pattern,int fi,int si){
        if(si>=pattern.length && fi>=str.length){//字符串和pattern都走完了，则为true
            return true;
        }
        if(si>=pattern.length && fi<str.length){ //字符串没走完，pattern走完了，那就false
            return false;
        }
        if(si+1<pattern.length && pattern[si+1]=='*'){ //如果当前字符后面是有*的
            if(fi<str.length && (pattern[si]==str[fi] || pattern[si]=='.')){
                return process(str,pattern,fi+1,si) || process(str,pattern,fi,si+2); //匹配一个pattern字符 || 匹配0个pattern字符
            }else{//如果字符串已经走到了结尾的字符了，
                //则pattern跳过当前的字符到下一个字符继续和字符串最后一个字符比较
                return process(str,pattern,fi,si+2);
            }
        }else{ //当前字符后面没有*
            if(fi<str.length && (str[fi]==pattern[si] || pattern[si]=='.')){
                return process(str,pattern,fi+1,si+1);
            }
            return false;

        }
    }
}
