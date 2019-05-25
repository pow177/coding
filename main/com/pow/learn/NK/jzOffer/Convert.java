package main.com.pow.learn.NK.jzOffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路：
 * 1.搜索二叉树的中序遍历是升序的，用中序遍历
 * 2.用一个指针指向上一个节点
 * 3.到当前节点的时候，将当前节点的left指针指向上一个节点，上一个节点的right指针指向当前节点
 * 上面这种方式不会因为破坏原来的指针结构而影响中序的遍历结果
 */
public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        bfs(pRootOfTree);
        return head;
    }

    TreeNode last = null;
    TreeNode head = null;
    public void bfs(TreeNode root){
        if(root==null){
            return;
        }
        bfs(root.left);
        if(last!=null){
            last.right = root;
            root.left = last;
        }else{
            head = root;
        }

        last = root;
        bfs(root.right);
    }
}
