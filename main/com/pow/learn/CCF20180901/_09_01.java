package main.com.pow.learn.CCF20180901;

import java.util.*;
public class _09_01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int counts = Integer.parseInt(sc.nextLine());
        long[] arr = new long[counts];
        long[] help = new long[counts];
        String[] data = sc.nextLine().split(" ");
        for(int i=0;i<counts;i++){
            int l = i-1;
            long value = Long.parseLong(data[i]);
            arr[i] = value;
            if(i>0 && i<counts-1){
                help[l] = l-1<0?(arr[l]+arr[i])/2:(arr[l-1]+arr[l]+arr[i])/3;
            }else if(i==counts-1){
                help[i] = (arr[i]+arr[l])/2;
                help[l] = (arr[l-1]+arr[l]+arr[i])/3;
            }
        }
        for(int i=0;i<counts;i++){
            System.out.print(help[i]+" ");
        }
    }
}