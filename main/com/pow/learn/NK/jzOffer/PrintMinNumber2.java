package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：用冒泡排序的方法，但是比较的方式是根据 ab ba组合成的大小比较，如果 序列是{a,b} 如果ab大于ba 那需要把a和b交换位置。
 * 把对于组合来说较大的数往后放，然后按顺序接起来之后就是最小的数
 */
public class PrintMinNumber2 {
    public static void main(String[] args) {
        int[] t = {2,999,3333};
        PrintMinNumber2 p = new PrintMinNumber2();
        String s = p.PrintMinNumber(t);
    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0){
            return "";
        }
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<numbers.length;i++){
            for(int j=numbers.length-1;j>i;j--){
                int a = numbers[j-1];
                int b = numbers[j];
                long a1 = Long.parseLong(a+""+b);
                long b1 = Long.parseLong(b+""+a);
                if(a1>b1){
                    swap(j,j-1,numbers);
                }
            }
        }
        for(int i:numbers){
            sbf.append(i+"");
        }
        return sbf.toString();
    }

    public void swap(int i,int j,int[] a){
        int tmp = a[i];
        a[i]  = a[j];
        a[j] = tmp;
    }
}
