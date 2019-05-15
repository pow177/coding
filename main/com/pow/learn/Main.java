package main.com.pow.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
public class Main {
    public static void main(String[] args) {
//        int n = 2>>1;
//        System.out.println(n);
//        new ArrayList<>().toA
//
//        Queue q = new LinkedList();
//        Main m = new Main();
////        int[][] gs = new int[3][3];
////        Scanner sc = new Scanner(System.in);
////        for(int i=0;i<3;i++){
////            gs[i][0] = sc.nextInt();
////            gs[i][1] = sc.nextInt();
////            gs[i][2] = sc.nextInt();
////        }
//        JSONObject js = JSONObject.parseObject("{\"list\":[[9,9,0,8,9,0,5,7,2,2,7,0,8,0,2,4,8],[4,4,2,7,6,0,9,7,3,2,5,4,6,5,4,8,7],[4,9,7,0,7,9,2,4,0,2,4,4,6,2,8,0,7],[7,7,9,6,6,4,8,4,8,7,9,4,7,6,9,6,5],[1,3,7,5,7,9,7,3,3,3,8,3,6,5,0,3,6],[7,1,0,7,5,0,6,6,5,3,2,6,0,0,9,5,7],[6,5,6,3,8,1,8,6,4,4,3,4,9,9,3,3,1],[1,0,2,9,7,9,3,1,7,5,1,8,2,8,4,7,6],[9,6,7,7,4,1,4,0,6,5,1,9,0,3,2,1,7],[2,0,8,7,1,7,4,3,5,6,1,9,4,0,0,2,7],[9,8,1,3,8,7,1,2,8,3,7,3,4,6,7,6,6],[4,8,3,8,1,0,4,4,1,0,4,1,4,4,0,3,5],[6,3,4,7,5,4,2,2,7,9,8,4,5,6,0,3,9],[0,4,9,7,1,0,7,7,3,2,1,4,7,6,0,0,0]]}");
//        List<Integer[]> te = JSON.parseArray(js.getJSONArray("list").toJSONString(),Integer[].class);
////        m.minPathSum(gs);
//        Integer[][] integers = new Integer[te.size()][];
//        te.toArray(integers);
//
//        int r = m.minPathSum(integers);
//        System.out.println(r);
//       int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        printMatrixZig(arr);


    }
//   public static void printMatrixZig(int[][] matr){
//        int aR = 0;
//        int aC = 0;
//        int bR = 0;
//        int bC = 0;
//        int endR = matr.length-1;
//        int endC = matr[0].length-1;
//        boolean fromUp = false;
//        while ((aR!=endR+1)){
//            prinLevel(matr,aR,aC,bR,bC,fromUp);
//            aR = aC==endC?aR+1:aR;
//            aC = aC==endC?aC:aC+1;
//            bC = bR==endR?bC+1:bC;
//            bR = bR==endR?bR:bR+1;
//            fromUp=!fromUp;
//        }
//   }
//
//   public static void prinLevel(int[][]m,int tR,int tC,int dR,int dC,boolean f){
//        if(f){
//            while (tR!=dR+1){
//                System.out.println(tR+"/"+tC);
//                System.out.println(m[tR++][tC--]+" ");
//            }
//        }else{
//            while (dR!=tR-1){
//                System.out.println(dR+"/"+dC);
//                System.out.println(m[dR--][dC++]+" ");
//            }
//        }
//   }

    public int minPathSum(Integer[][] grid) {
        Integer[][] help = new Integer[grid.length][grid[0].length];
        for(int i=grid.length-1;i>=0;i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                help[i][j] = null;
            }
        }
        help[grid.length-1][grid[0].length-1] = 0;
                for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){

                if(i-1>=0 && (help[i-1][j]==null || (help[i-1][j]!=null && help[i-1][j]>grid[i][j]+ help[i][j]))){
                    help[i-1][j] = grid[i][j]+ help[i][j];
                }

                if(j-1>=0 && (help[i][j-1]==null || (help[i][j-1]!=null && help[i][j-1]>grid[i][j]+ help[i][j]))){
                    help[i][j-1] = grid[i][j]+ help[i][j];
                }
            }
        }
        return help[0][0]+grid[0][0];
    }
}
/** Scanner sc = new Scanner(System.in);
 int counts = Integer.parseInt(sc.nextLine());
 Set<Long> set = new HashSet<>();
 String[] tmp = sc.nextLine().split(" ");
 long target = Long.parseLong(sc.nextLine());
 for(int i =0;i<counts;i++){
 long cur = Long.parseLong(tmp[i]);
 set.add(cur);
 }

 for(int i =0;i<counts;i++){
 long cur = Long.parseLong(tmp[i]);
 long tmpTarget = target;
 for(int j=i;j<counts;j++){
 if(set.contains(tmpTarget-cur)){
 System.out.println("yes");
 return;
 }else{
 tmpTarget  = tmpTarget-cur;
 }
 }

 }
 System.out.println("no");**/