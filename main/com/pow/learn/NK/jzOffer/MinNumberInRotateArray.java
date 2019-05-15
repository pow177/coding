package main.com.pow.learn.NK.jzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路：因为输入的是旋转数组，所以首个数字一定比旋转部分的值都要大，
 * 以第一个数字为比较点，用二分的方式，left mid right。
 * 如果mid的值比第一个数字大，选择右边部分。即left = mid
   如果mid的值比第一个数字小，选择左边部分。即right = mid
  当left = mid时，right就是最小值
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        int firstNum = array[0];
        int left = 0;
        int right = array.length-1;
        int mid = (left+right)/2;
        while(left!=mid){
            if(array[mid]<firstNum){
                right = mid;
                mid = (left+right)/2;
            }else{
                left = mid;
                mid = (left+right)/2;
            }
        }
        return array[right];
    }
}
