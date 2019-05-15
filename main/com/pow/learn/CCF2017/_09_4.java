package main.com.pow.learn.CCF2017;

import java.util.*;
public class _09_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String spStr = sc.nextLine();
        int c = Integer.parseInt(spStr.split(" ")[1]);
        int n = Integer.parseInt(spStr.split(" ")[0]);
        Map<Integer,Node> map = new HashMap<>();
        Map<Integer,Set<Integer>> helpMapSet = new HashMap<>();
        for(int i=1;i<=n;i++){
            helpMapSet.put(i,new HashSet<Integer>());
        }
        for(int i =0;i<c;i++){
            String spStr2 = sc.nextLine();
            int n1 = Integer.parseInt(spStr2.split(" ")[0]);
            int n2 = Integer.parseInt(spStr2.split(" ")[1]);
            Node node1 = null;
            Node node2 = null;
            if(!map.containsKey(n1)) {
                node1 = new Node(n1);
                map.put(n1,node1);
            }else {
                node1 = map.get(n1);
            }
            if(!map.containsKey(n2)) {
                node2 = new Node(n2);
                map.put(n2,node2);
            }else {
                node2 = map.get(n2);
            }
            Edge edge = new Edge(node1,node2);
            node2.inEdge.add(edge);
            node1.outEdge.add(edge);
        }
        int counts = 0;
        for(Node node:map.values()){
            processNext(node,helpMapSet,node.value);
            node.state=true;
        }
        for(int i=1;i<=n;i++){
            Set<Integer> curSet = helpMapSet.get(i);
            Iterator<Integer> iterator = curSet.iterator();
            while (iterator.hasNext()){//遍历当前关联的所有节点
                int chi = iterator.next();
                Set<Integer> chiSet  = helpMapSet.get(chi);
                    chiSet.add(i);
            }

        }
        for(Set<Integer> curSet:helpMapSet.values()){
            if(curSet.size()==n){
                counts++;
            }
        }
        System.out.println(counts);
    }

    public static void processNext(Node curNode,Map<Integer,Set<Integer>> mapSet,Integer root){
        Set<Integer> set = mapSet.get(root);
        if(curNode.state){ //直接添加该节点所有能到达的点，因为已经遍历过了
            set.addAll(mapSet.get(curNode.value));
            return;
        }
        set.add(curNode.value);
        for(Edge edge:curNode.outEdge){
            if(!set.contains(edge.toNode.value)) {
                processNext(edge.toNode, mapSet, root);
            }
        }

    }



    public static class Node{
        int value;
        List<Edge> outEdge;
        List<Edge> inEdge;
        boolean state;
        public Node(int value){
            this.value = value;
            this.outEdge = new ArrayList<>();
            this.inEdge  =new ArrayList<>();
            this.state = false;
        }
    }
    public static class Edge{
        Node fromNode;
        Node toNode;
        boolean state;
        public Edge(Node f,Node t){
            this.fromNode = f;
            this.toNode = t;
            this.state = true;
        }
    }
}

/**
 Set<Integer> curSet = mapSet.get(curNode.value);
 Set<Integer> rootSet = mapSet.get(root);
 curSet.add(curNode.value);    //当前set存当前Node值
 curSet.add(root);    //当前set存root值
 rootSet.add(curNode.value);    //root存set值

 for(Edge edge:curNode.outEdge){
 if(f) {
 if (edge.state) {
 edge.state = false;
 processNext(edge.toNode, mapSet, root,f);
 }
 }else {
 if (!edge.state) {
 edge.state = true;
 processNext(edge.toNode, mapSet, root,f);
 }
 }
 }**/