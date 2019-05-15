package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请
 * 重建出该二叉树。假设输入的前序遍历和中序遍
 * 历的结果中都不含重复的数字。例如输入前序遍历
 * 序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思路：前序遍历的序列，每一个都是一个子树的根节点。
 * 例如：先序的第一个数字1，在中序序列中，找到1的位置，将1左右两边的数分成左右子树，看成两个子序列{4,7,2} {5,3,8,6}
 * 先序的第二个数字 2， 在{4,7,2}序列中找到2，将2的左右两边分为两颗子树{4,7} {null}
 * 先序的第三个数字 4, 在{4,7}中找到4的位置分成左右两个子树 {null} {7}。
 * 以此类推。每一层都分左右子树，直到分不出为止，然后return 当前根节点到上一层，上一层再连接该节点
 */
public class ReConstructBinaryTree {
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree r = new ReConstructBinaryTree();
        TreeNode root  = r.reConstructBinaryTree(pre,in);
        System.out.println(root);
    }
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            map.put(in[i],i);
        }
        return process(pre,in,map,new HashSet<Integer>(),0,pre.length-1);
    }
   private int preIndex;
    public TreeNode process(int[] pre,int[] in,Map<Integer,Integer> map,Set<Integer> setBeen,int left,int right){
        if(left<0 || right>in.length-1 || setBeen.contains(left) ||setBeen.contains(right)){
            return null;
        }
        int curVal = pre[preIndex++];
        TreeNode curNode = new TreeNode(curVal);
        int mid = map.get(curVal);
        setBeen.add(mid);
        TreeNode leftNode = process(pre,in,map,setBeen,left,mid-1);
        TreeNode rightNode = process(pre,in,map,setBeen,mid+1,right);
        curNode.left = leftNode;
        curNode.right = rightNode;
        return curNode;
    }
}
