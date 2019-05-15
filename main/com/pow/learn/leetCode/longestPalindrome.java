package main.com.pow.learn.leetCode;

import java.util.Scanner;

public class longestPalindrome {
    public static void main(String[] args){
        longestPalindrome l = new longestPalindrome();
        System.out.println(l.longestPalindrome(new Scanner(System.in).next()));
    }

    public String longestPalindrome(String s) {
        char[] helpC = s.toCharArray();
        StringBuffer sbf  = new StringBuffer();

        for(int i =0;i<helpC.length;i++){
            sbf.append("#");
            sbf.append(helpC[i]);
        }
        sbf.append("#");
        char[] arr = sbf.toString().toCharArray();
        int[] help = new int[arr.length];
        int maxIndex = 0;
        for(int i=1;i<arr.length-1;i++){
            int l = i-1;
            int r = i+1;
            help[i] = 1;
            while(l>=0 && r<=arr.length-1 && arr[l--]==arr[r++]){
                help[i] = help[i]+2;
            }
            if(help[i]>help[maxIndex]){
                maxIndex = i;
            }
        }
        int Long = help[maxIndex]/2;
        String result = String.valueOf(arr).substring(maxIndex-Long,maxIndex+Long+1).replace("#","");
        System.out.println(result);
        return result;
    }
}
