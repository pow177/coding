package main.com.pow.learn.NK;

public class prinZ {
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixZig(arr);
    }

    public static void printMatrixZig(int[][] matr){
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matr.length-1;
        int endC = matr[0].length-1;
        boolean fromUp = false;
        while ((aR!=endR+1)){
            prinLevel(matr,aR,aC,bR,bC,fromUp);
            aR = aC==endC?aR+1:aR;
            aC = aC==endC?aC:aC+1;
            bC = bR==endR?bC+1:bC;
            bR = bR==endR?bR:bR+1;
            fromUp=!fromUp;
        }
    }

    public static void prinLevel(int[][]m,int tR,int tC,int dR,int dC,boolean f){
        if(f){
            while (tR!=dR+1){
                System.out.println(tR+"/"+tC);
                System.out.println(m[tR++][tC--]+" ");
            }
        }else{
            while (dR!=tR-1){
                System.out.println(dR+"/"+dC);
                System.out.println(m[dR--][dC++]+" ");
            }
        }
    }
}
