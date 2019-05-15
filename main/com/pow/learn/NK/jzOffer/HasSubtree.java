package main.com.pow.learn.NK.jzOffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：用先序遍历的顺序访问A树，比较节点的值，如果当前节点的值和B数的根节点的值相等
 * 那么以当前节点为根，递归比较该节点和B树是否结构和值相等。
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null){
            return false;
        }
        int starVal = root2.val;
        return preJu(root1,root2,starVal);
    }

    public boolean preJu(TreeNode root1,TreeNode root2,int starVal){
        if(root1==null){
            return false;
        }
        boolean f = preJu(root1.left,root2,starVal);
        if(f){
            return f;
        }
        int curVal = root1.val;
        if(curVal==starVal){
            f = isSub(root1,root2);
            if(f){
                return f;
            }
        }
        f = preJu(root1.right,root2,starVal);
        if(f){
            return f;
        }
        return false;
    }

    public boolean isSub(TreeNode root1, TreeNode root2){
        if(root1==null && root2!=null){
            return false;
        }
        if(root2==null){
            return true;
        }
        if(root2.val!=root1.val){
            return false;
        }
        return isSub(root1.left,root2.left) && isSub(root1.right,root2.right);
        //先左后右的顺序比较
    }
     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
