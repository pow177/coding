package main.com.pow.learn.NK.jzOffer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *
 * 思路： a^a = 0   0^b = b
 *
 * 因为一个数组只有两个出现一次的数组，则把整个数组都异或一遍。只剩下a^b
 *
 * 因为异或的性质，可以找出第一个出现1的位置，a和b一定在这个位置上是不同的。
 * 根据这个位置是否为1，把数组分割成2个数组。两个数组分别各自异或。就能分别得到a和b了。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int dif = 0;
        for(int i:array){
            dif = dif^i;
        }

        int firOne = 0;
        //找出第一个出现1的位置
        while(firOne<32){
            if((dif&1)==1){
                break;
            }
            dif = dif>>1;
            firOne++;
        }
        int[] a1 = new int[array.length];
        int[] a2 = new int[array.length];
        int p1 = 0;
        int p2 = 0;
        for(int i:array){
            int j = (i>>firOne)&1;   //看看这个位置是否为1，分为2个数组
            if(j==1){
                a1[p1++] = i;
            }else{
                a2[p2++] = i;
            }
        }

        for(int i=0;i<p1;i++){
            num1[0] = num1[0]^a1[i];
        }
        for(int i=0;i<p2;i++){
            num2[0] = num2[0]^a2[i];
        }
    }
}
