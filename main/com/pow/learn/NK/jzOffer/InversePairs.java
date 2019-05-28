package main.com.pow.learn.NK.jzOffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 *
 * 思路：利用归并排序的方法解决逆序对问题。
 *
 * 例如：   L-mid: 1 2 3      mid+1-R:  0 4 5
 *
 * 归并的时候， p1指向的是1     p2指向的 0    ,这个时候比较大小。若1比0大，则当前p1到mid位置的所有数都大于0，
 * 则统计的变量count加上p1到mid之间个数，即mid-p1+1个数。
 *
 * 其他的按普通的归并去走就行了。
 *
 * 注意点：辅助数组可以通过主调用函数去创建并且传递给process和merge去使用，在merge里面直接new辅助数组，会造成超时
 * 还有是count计算完之后要取余，不然会超出范围。
 */
public class InversePairs {
    public static void main(String[] args) {
        InversePairs i = new InversePairs();
        int[] aa = {1,2,3,4,5,6,7,0,9,4,3,1,11,2,123,17,85,568,96,679,456,1235,235,2355,65778,35};
        int r = i.InversePairs(aa);
        System.out.println(r);
    }
    public int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] help = new int[array.length];
        process(help,array,0,array.length-1);
        return count;
    }

    public void process(int[] help,int[] array,int L,int R){
        if(L<R){
            int mid = (L+R)/2;
            process(help,array,L,mid);
            process(help,array,mid+1,R);
            merge(help,array,L,R,mid);
        }

    }
    int count = 0;
    public void merge(int[] help,int[] array,int L,int R,int mid){
        int p1 = L;
        int p2 = mid+1;

        int r = L;
        while(p1<=mid && p2<=R){
            if(array[p1]<=array[p2]){
                help[r++] = array[p1++];
            }else{
                help[r++] = array[p2++];
                count = (count+mid-p1+1)%1000000007;
            }

        }

        while(p1<=mid){
            help[r++] = array[p1++];
        }

        while(p2<=R){
            help[r++] = array[p2++];
        }

        System.arraycopy(help,L,array,L,R-L+1);
    }
}
