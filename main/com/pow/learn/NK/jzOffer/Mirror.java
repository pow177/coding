package main.com.pow.learn.NK.jzOffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 思路：遍历。将每个节点的左右节点相互交换
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
