package main.com.pow.learn.NK.xz2018;
import java.util.*;

/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。
 * 每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i]
 * (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，
 * 使得最多的小孩上台表演。可以保证每个w[i]>
 * 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 *
 * 输入描述:
 * 第一行：n，表示h数组元素个数
 *  第二行：n个h数组元素
 *  第三行：m，表示w数组元素个数
 *  第四行：m个w数组元素
 *
 *
 *  3
 *  2 2 3
 *  2
 *  3 1
 *
 *  思路：贪心。巧克力和孩子需要的都各自一个数组然后排序。巧克力依次从小到达找
 */
public class LiuYi61 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] h = sc.nextLine().split(" ");
        int[] hA = new int[n];

        int m = sc.nextInt();
        sc.nextLine();
        String[] w = sc.nextLine().split(" ");
        int[] wA = new int[m];
        int result = 0;
        for(int i=0;i<n;i++){
            hA[i] = Integer.parseInt(h[i]);
        }
        for(int i=0;i<m;i++){
            wA[i] = Integer.parseInt(w[i]);
        }
        Arrays.sort(hA);
        Arrays.sort(wA);
        int i =0;
        int j = 0;
        while(i<n && j<m){   //因为是从小到达的顺序，即当前巧克力无法被当前的小朋友拿，那后面的情况也不可能
            if(hA[i]<=wA[j]){
                result++;
                i++;
            }
            j++;
        }
        System.out.println(result);
    }
}
