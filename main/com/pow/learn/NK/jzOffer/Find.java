package main.com.pow.learn.NK.jzOffer;

/**
 * 在一个二维数组中
 * （每个一维数组的长度相同）
 * ，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    /**
     * 思路： 由于数组是从左到右，从上到下有序递增的。那么可以通过这个规律排除大量的位置，加快遍历速度。
     *
     * 1.我选择的是先从 第一行从左往右先遍历，找到最后一个比target小的数 [i1][j1]
     * （该位置的数后面的数都比target大，所以后面的列往下行的肯定比target大，则可以排除这部分数据）
     *
     * 2.然后从这个最后一个比target小的数往下走，即列不变， r++。找到比target大的数，[i2][j2]
     * 3.然后往左走，即[i2][j2--],直到遍历到比target小的位置，或者i2越界为止。然后 行往下走一行，即i2+1.  列复原到j1位置。
     * 4.重复步骤3.直到i2越界为止
     *
     * 以上过程中都需要做是否跟target相等的比较，若找到相等的则直接return true
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int r = 0;
        int c = 0;
        if(array[0].length==0){
            return false;
        }
        if(target>array[array.length-1][array[0].length-1]){
            return false;
        }
        while(true){
            if(target>array[r][c]){
                c++;
            }
            else if(target==array[r][c]){
                return true;
            }
            else if(target<array[r][c]){
                c--;
                break;
            }
            if(c==array[0].length){
                c--;
                break;
            }
        }
        if(c==-1){
            return false;
        }
        int reSet = c;
        while(true){
            if(c==-1){
                c = reSet;
                r++;
            }
            if(r==array.length){
                return false;
            }
            if(target<array[r][c]){
                c--;
            }
            else if(target>array[r][c]){
                c = reSet;
                r++;
            }else if(target==array[r][c]){
                return true;
            }


        }

    }
}
