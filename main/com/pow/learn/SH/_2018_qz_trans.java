package main.com.pow.learn.SH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * unfinish
 */
public class _2018_qz_trans {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(true) {
            String[] str = sc.nextLine().split(" ");
            int all = 0;
            int n = 0;
            int p1 = Integer.parseInt(str[0]);
            int p2 = Integer.parseInt(str[1]);
            int p3 = Integer.parseInt(str[2]);
            int p4 = Integer.parseInt(str[3]);
            int p5 = Integer.parseInt(str[4]);
            int p6 = Integer.parseInt(str[5]);

            //装6
            n += p6;
            //装5,5+10个1
            n += p5;
            p1 = p1 - p5 * 10 < 0 ? 0 : p1 - p5;
            //装4,4+2,5个2. 4+1,20个1
            n += p4;

            int addP2T = p2 != 0 ? p2 / 5 : 0;
            int addP1T = p1 != 0 ? p1 / 20 : 0;
            if (addP2T >= p4) { //被2刚好填满 或者 p2有剩
                p2 = p2 - p4 * 5;
            } else {  //需要填充1 2


                p4 = p4 - addP2T;
                p2 = p2 % 5; //零散个数，
                int allLs = p4 * 20;
                if (p2 * 4 <= allLs) { //装2
                    allLs = allLs - p2 * 4;
                    p2 = 0;
                } else {
                    p2 = (p2 * 4 - allLs) / 4;
                }
                if (p1 < allLs) {  //装1
                    p1 = 0;
                } else {
                    p1 = p1 - allLs;
                }

            }

        }
        }
}
