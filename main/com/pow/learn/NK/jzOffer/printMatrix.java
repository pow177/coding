package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：用两个点标识最左上交和最右下角这两个点，用来控制打印的循环路径。
 *     ps：行×列 1.分4种情况：
 *     a.两个点的x,y都不同。
 *     b.两个点的x相同，y不同（即N *1 ）
 *     c.两个点的x不同，y相同(即1*N)
 *     d.两个点完全重合，即一个点
 *
 *     b c d都很简单，直接往左依次打印，或者往下依次打印，或者打印一个点就行了
 *
 *     a情况的话，就从x1,y1的位置先往左打印，然后到 c = x2的位置开始往下打印，到r = y2的时候，往左打印，到c = x1的时候往上打印
 *     又重新回到x1,y1位置后，x1++,y1++,y2--,x2--。往内缩一个圈继续按4种情况去分类打印。直到list长度和矩阵的数的数量一致
 */
public class printMatrix {
    public static void main(String[] args){
        printMatrix p = new printMatrix();
        int[][] ma = {{1},{5},{9}};
        p.printMatrix(ma);
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = 0;
        int c = 0;
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix[0].length-1;
        int y2 = matrix.length-1;
        while(true){
            if(x1<x2 && y1<y2) {
                for (int i = x1; i < x2; i++) {
                    list.add(matrix[r][c++]);
                }
                for (int i = y1; i < y2; i++) {
                    list.add(matrix[r++][c]);
                }
                for (int i = x2; i > x1; i--) {
                    list.add(matrix[r][c--]);
                }
                for (int i = y2; i > y1; i--) {
                    list.add(matrix[r--][c]);
                }

            }else if(x1==x2 && y1!=y2){
                for(int i=y1;i<=y2;i++){
                    list.add(matrix[r++][c]);
                }
            }else if(x1!=x2 && y1==y2){
                for(int i=x1;i<=x2;i++){
                    list.add(matrix[r][c++]);
                }
            }else if(x1==x2 && y1==y2){
                list.add(matrix[r][c]);
            }
            if (matrix[0].length * matrix.length == list.size()) {
                break;
            }
            x1++;
            y1++;
            x2--;
            y2--;
            r = y1;
            c = x1;
        }
        return list;
    }
}
