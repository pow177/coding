package main.com.pow.learn.NK.jzOffer;

import java.util.*;
/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 用先序遍历的方式去做处理，注意为子节点的时候才需要判断是否添加
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(root,result,0,target);
        return result;
    }

    ArrayList<Integer> listHelp = new ArrayList<>();
    public void dfs(TreeNode root,ArrayList<ArrayList<Integer>> resultList,int curSum,int target){
        if(root==null){
            return;
        }
        curSum+=root.val;
        listHelp.add(root.val);
        if(root.left==null && root.right==null &&curSum==target){
            ArrayList<Integer> store = new ArrayList<>(listHelp);
            resultList.add(store);
        }


        dfs(root.left,resultList,curSum,target);
        dfs(root.right,resultList,curSum,target);
        listHelp.remove(listHelp.size()-1);
    }


}
