package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路:用获取树深度的方法，对根节点的左右子树分别进行计算，左右子树的深度的差的绝对值超过1则不平衡
 */
public class IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = process(root.left);
        int right = process(root.right);
        return Math.abs(left-right)>1?false:true;
    }

    public int process(TreeNode root){
        if(root==null){
            return 0;
        }
        int left =  process(root.left)+1;
        int right =  process(root.right)+1;

        return Math.max(left,right);
    }
}
