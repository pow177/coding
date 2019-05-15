package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：从length-2->0的顺序，每次遍历从当前位置index->length-1，当前数为偶数。
 * 且在路上遇到奇数，则和该数交换位置。（类似冒泡排序）
 */
public class reOrderArray {
    public void reOrderArray(int [] array) {
        for(int i=array.length-1;i>=0;i--){
            int index = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]%2!=0 && array[index]%2==0){
                    swap(index,j,array);
                    index = j;
                }else{
                    break;
                }
            }
        }

    }

    public void swap(int i,int j,int[] array){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
