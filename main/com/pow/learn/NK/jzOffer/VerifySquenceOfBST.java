package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：1.二叉树的左子树的值小于根节点的值，右子树的值大于根节点的值。
 *       2.数组中最后一个数是根节点的值
 *       3.从0位置开始遍历找到第一个大于根节点的值的位置i，
 *       0至（i-1)位置是左子树，i至end-1是右子树的位置。
 *       判断左子树的所有值是否小于根节点，右子树的值是否都大于根节点。
 *       4.把左子树/右子树部分再独立看成是一棵树，判断左子树是否小于根节点，右子树是否大于根节点。
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        boolean b = v.VerifySquenceOfBST(new int[]{3,1,2,5,7,6,4});
        System.out.println(b);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return judge(0,sequence.length-1,sequence);
    }

    public boolean judge(int start,int end,int[] s){
        //3节点为一组再往下一层就到这个basecase了，为搜索二叉树的情况下
        if(start>=end){
            return true;
        }
        int i = 0;
        for(;s[i]<s[end] && i<end;i++){
        }
        for(int j=i+1;j<end;j++){
            if(s[j]<s[end]){
                return false;
            }
        }
        return judge(start,i-1,s) && judge(i,end-1,s);
    }
}
