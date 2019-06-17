package main.com.pow.learn.NK.jzOffer;

/**
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*.
 * ..*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 *
 *
 * 思路： 因为对于b数组来说，第i的数不乘进去，即可以把第i个数当成1
 *
 * 例如 A: 1 2 3 4 5
 *
 * B0  (1) 2 3 4 5   （这里全是对应每行的乘机为该位置的元素）
 * B1  1 (1) 3 4 5
 * B2  1 2 (1) 4 5
 * B3  1 2 3 (1) 5
 * B4  1 2 3 4 (1)
 *
 * 按第i个位置来划分来看的话，可以看出可以第i个位置把数组分成前和后部分。
 *
 * 可以找到规律是  B1 = B0 * A0
 *                B2 = B1 * A1
 *         这个是算第i个位置左边部分的乘积的
 *                Bj-2 = Bj-1 * Aj-1
 *                Bj-3 = Bj-2 * Aj-2
 *         这个是算出第i个位置右边部分的乘积的
 *
 *              左右两部分相乘得到对应 Bi 的值
 *
 */
public class multiply {
    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        b[0] = 1;
        for(int i=1;i<b.length;i++){
            b[i] = b[i-1] *A[i-1];

        }
        int tmp = 1;
        for(int i=b.length-2;i>=0;i--){
            tmp = tmp*A[i+1];
            b[i] = tmp*b[i];
        }
        return b;
    }
}
