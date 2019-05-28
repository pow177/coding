package main.com.pow.learn.NK.jzOffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路:用二分查找法。当查到等于k的位置时，循环遍历k的左右两边。看是否还有相同的k的值。
 */
public class GetNumberOfK {
    int count = 0;
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==1){
            return array[0]==k?1:0;
        }
        binarySearch(array,k,0,array.length-1);
        return count;
    }

    public void binarySearch(int[] array,int k,int L,int R){
        if(L<R){
            int mid = (L+R)>>1;
            if(array[mid]!=k){
                if(k>array[mid]){
                    binarySearch(array,k,mid+1,R);
                }else{
                    binarySearch(array,k,L,mid);
                }
            }else{
                count++;
                int p1 = mid-1;
                int p2 = mid+1;
                while(p1>=0 && array[p1--]==k){
                    count++;
                }
                while(p2<=array.length-1 && array[p2++]==k){
                    count++;
                }
            }
        }
    }
}
