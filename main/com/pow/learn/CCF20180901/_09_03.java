package main.com.pow.learn.CCF20180901;

import java.util.*;

public class _09_03 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       String inputStr = sc.nextLine();
       int c1 = Integer.parseInt(inputStr.split(" ")[0]);
       int c2 = Integer.parseInt(inputStr.split(" ")[1]);
       Node root = null;
       Node lastNode = null;
       Map<String,Node> map = new HashMap<>();
       for(int i=1;i<=c1;i++){
           int curLevel = 0;
           String tmp = sc.nextLine();
           String value = tmp.trim();
           String id = null;

           if(value.contains("#")){
               id = value.split(" ")[1];
               value = value.split(" ")[0];
           }

           for(int l = 0;l<tmp.length();l++){  //计算当前的level
               if(tmp.charAt(l)!=32) {
                   break;
               }
               curLevel++;
           }
           //构造Node
           Node currNode = new Node(value);
           currNode.level = curLevel;
           currNode.line = i;
           currNode.value = value;
           if(id!=null){
               map.put(id,currNode);
           }
           if(lastNode==null){
               lastNode = currNode;
               root = currNode;
               continue;
           }
           //找到父节点与子节点建立关系
           if(curLevel>lastNode.level){
               lastNode.chidrens.add(currNode);
               currNode.parent = lastNode;
           }else if(curLevel == lastNode.level){
               lastNode.parent.chidrens.add(currNode);
               currNode.parent = lastNode.parent;
           }else if(curLevel < lastNode.level){
               Node findBigLevel = lastNode;
               while (curLevel<=findBigLevel.level){
                       if(findBigLevel==null){
                           break;
                       }
                       findBigLevel = findBigLevel.parent;
               }
               if(findBigLevel!=null) {
                   findBigLevel.chidrens.add(currNode);
                   currNode.parent = findBigLevel;
               }
           }
           lastNode = currNode;
       }

       List<List<Integer>> results = new ArrayList<>();
       for(int i=1;i<=c2;i++){
           String tmpStr = sc.nextLine();
           String[] checkStr = tmpStr.split(" ");
           if(tmpStr.contains("#")){
               List<Integer> integerList = new ArrayList<>();
               integerList.add(map.get(tmpStr).line);
               results.add(integerList);
               continue;
           }
           List<Integer> tmpList = new ArrayList<>();
           process(checkStr,0,root,tmpList);
           results.add(tmpList);
       }

       for(List<Integer> list:results){
           System.out.print(list.size()+" ");
           for(Integer i:list){
               System.out.print(i+" ");
           }
           System.out.println();
       }
    }
    public static void process(String[] keys,int index,Node root,List<Integer> resultList){
        if(root==null){
            return;
        }
        String key = keys[index];
       if(root.value.equals(key)){
           index++;
       }
        if(index==keys.length){
            resultList.add(root.line);
            return;
        }
       for(Node n:root.chidrens) {
           process(keys, index,n,resultList);
       }

    }
    public static class Node{
        Node parent;
        String value;
        int level;
        int line;
        List<Node> chidrens;
        public Node(String value){
            this.chidrens = new ArrayList<>();
        }
    }
}
