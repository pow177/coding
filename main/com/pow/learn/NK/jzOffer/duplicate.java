package main.com.pow.learn.NK.jzOffer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 思路：这里我用了插入排序去写，虽然没用额外空间但是有点费时
 *
 * 用HashSet也可以做，和辅助标记数组也可以，要额外空间
 *
 * 另一种辅助数组做标记的方法，用现有的数组numbers，从0位置开始，对应的值把对应的index的值+n,因为题意是说了只有0-n-1的大小。
 * 当遍历到第一个大于n的时候，这个数就是第一次出现的重复的数值
 */
public class duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i=1;i<length;i++){
            for(int j=i;j>0;j--){
                if(numbers[j]<numbers[j-1]){
                    swap(j,j-1,numbers);
                }else if(numbers[j]==numbers[j-1]){
                    duplication[0] = numbers[j];
                    return true;
                }

            }
        }
        return false;
    }

    public void swap(int i,int j,int[] array){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
