package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 思路：用遍历查每个节点的左右节点，并返回较大的一个则遍历的较深。
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        return process(root,0);
    }

    public int process(TreeNode root,int l){
        if(root==null){
            return 0;
        }
        int left = process(root.left,l)+1;
        int right = process(root.right,l)+1;
        return Math.max(left,right);
    }
}
