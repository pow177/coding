package main.com.pow.learn.CCF2018;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _12_4 {
    public static class Edge{
        int weight;
        Node from;
        Node to;

        public Edge(int weight,Node from,Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static class Node{
        int value;
        Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int root = Integer.parseInt(sc.nextLine());
        UnionFind unionFind = new UnionFind(n);
        PriorityQueue<Edge> sHead = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        for(int i = 0;i<m;i++){
            String[] datas = sc.nextLine().split(" ");
            int w = Integer.parseInt(datas[2]);
            int from = Integer.parseInt(datas[0]);
            int to = Integer.parseInt(datas[1]);
            Edge edge = new Edge(w,new Node(from),new Node(to));
            sHead.add(edge);
        }

        int mostWeight = 0;
        while(!sHead.isEmpty()){
            Edge sEdge = sHead.poll();
            Node node1 = sEdge.from;
            Node node2 = sEdge.to;
            if(!unionFind.isSameSet(node1.value,node2.value)){
                unionFind.union(node1.value,node2.value);
                mostWeight = mostWeight>sEdge.weight?mostWeight:sEdge.weight;
            }
        }
        System.out.println(mostWeight);
    }

    public static class UnionFind{
        int[] parent;
        int count;
        int[] size;
        UnionFind(int count){
            parent = new int[count+1];
            size = new int[count+1];
            this.count = count+1;
            for(int i=0;i<count;i++){
                parent[i] = i;
                size[i] = 1;
            }

        }
        public boolean isSameSet(int a,int b){
            int aRoot = find(a);
            int bRoot = find(b);
            return aRoot==bRoot;
        }

        public void union(int a,int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }
            if(size[aRoot]<size[bRoot]) {
                size[bRoot] += size[aRoot];
                parent[aRoot] = bRoot;
            }else{
                size[aRoot] += size[bRoot];
                parent[bRoot] = aRoot;
            }

        }

        public int find(int a){
            if(parent[a]==a){
                return a;
            }
            while(parent[a]!=a){
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

    }
}
