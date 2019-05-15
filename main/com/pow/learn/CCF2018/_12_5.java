package main.com.pow.learn.CCF2018;


import java.util.*;

public class _12_5 {
    public static class Node{
        HashMap<Edge, Set<Edge>> edgeGetAfterNeedEdgeMap;
        HashMap<Edge, Integer> costMap;
        ArrayList<Edge> inEdges;
        ArrayList<Edge> outEdges;
        int value;
        public Node(int value){
            inEdges = new ArrayList<>();
            outEdges = new ArrayList<>();
            costMap = new HashMap<>();
            edgeGetAfterNeedEdgeMap = new HashMap<>();
            this.value = value;

        }
    }

    public static class Edge{
        int value;
        int status;
        String type;
        Node fromNode;
        Node toNode;

        public Edge(Node fromNode,Node toNode,int status,String type,int value){
            this.status = status;
            this.type = type;
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.value = value;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] acceptStrA = sc.nextLine().split(" ");
        int T = Integer.parseInt(acceptStrA[0]);
        int S = Integer.parseInt(acceptStrA[1]);
        int E = Integer.parseInt(acceptStrA[2]);

        ArrayList<Integer> resultList = new ArrayList<>();
        for(int ti = 0;ti<T;ti++){
            acceptStrA = sc.nextLine().split(" ");
            int n = Integer.parseInt(acceptStrA[0]);
            int m = Integer.parseInt(acceptStrA[1]);
            HashMap<Integer,Node> nodes = new HashMap<>();
            Set<Edge> edges = new HashSet<>();


            for(int mi=0;mi<m;mi++){
                acceptStrA = sc.nextLine().split(" ");
                int toNodeId = Integer.parseInt(acceptStrA[1]);
                int fromNodeId = Integer.parseInt(acceptStrA[0]);
                Node toNode;
                Node fromNode;
                if(!nodes.containsKey(toNodeId)){
                    toNode = new Node(toNodeId);
                    nodes.put(toNode.value,toNode);
                }else{
                    toNode = nodes.get(toNodeId);
                }

                if(!nodes.containsKey(fromNodeId)){
                    fromNode = new Node(fromNodeId);
                    nodes.put(fromNode.value,fromNode);
                }else {
                    fromNode = nodes.get(fromNodeId);
                }
                Edge edge = new Edge(fromNode,toNode,1,acceptStrA[2],E);

                toNode.inEdges.add(edge);
                fromNode.outEdges.add(edge);


                if(edge.type.equals("B") || edge.type.equals("A")) {
                    edges.add(edge);
                }

            }
            Node beginNode = nodes.get(1);
            markEdgeCost(beginNode,0,new HashSet<Edge>());

         int result = process(beginNode,0,edges);
            resultList.add(result);
        }
        for(Integer result:resultList){
            System.out.println(result);
        }
    }
    public static int process(Node beginNode,int sumCost,Set<Edge> allNeedClearRoad){
        if(beginNode.value==1 && sumCost>0 && allNeedClearRoad.size()==0){
            return sumCost;
        }

        ArrayList<Edge> edgeArrayList = beginNode.outEdges;
        Edge firstChoseByMaxNeed = null;
        Edge firstChoseByUnNeed = null;
        boolean flag = false;

        for(Edge edge:edgeArrayList){

            if(firstChoseByMaxNeed==null && edge.status==1){
                firstChoseByMaxNeed = edge;
            }
            if(firstChoseByUnNeed==null && edge.status==1){
                firstChoseByUnNeed = edge;
            }
            if(firstChoseByMaxNeed==null){
                continue;
            }
            Set<Edge> needClearSet = beginNode.edgeGetAfterNeedEdgeMap.get(edge);
            if(needClearSet!=null) {
                Iterator<Edge> iterator = needClearSet.iterator();
                while (iterator.hasNext()) {
                    Edge je = iterator.next();
                    if (!allNeedClearRoad.contains(je)) {
                        iterator.remove();
                    }
                }
            }
            int needClear = beginNode.edgeGetAfterNeedEdgeMap.get(edge).size();
            int cost = beginNode.costMap.get(edge);
            if(needClear>0 && !flag){
                flag = true;
            }
            int beforeNeedClear = beginNode.edgeGetAfterNeedEdgeMap.get(firstChoseByMaxNeed).size();
            int beforeCost = beginNode.costMap.get(firstChoseByUnNeed);
            firstChoseByMaxNeed  = (needClear>beforeNeedClear && edge.status==1) ||
                    (needClear==beforeNeedClear && cost<beginNode.costMap.get(firstChoseByMaxNeed) && edge.status==1)?edge:firstChoseByMaxNeed;
            firstChoseByUnNeed  = cost<beforeCost && edge.status==1?edge:firstChoseByUnNeed;
        }

        if(firstChoseByMaxNeed==null && firstChoseByUnNeed==null){
            return -1;
        }

        if(flag){
            String type = firstChoseByMaxNeed.type;
            switch (type){
                case "A":allNeedClearRoad.remove(firstChoseByMaxNeed);break;
                case "B":firstChoseByMaxNeed.status=0;allNeedClearRoad.remove(firstChoseByMaxNeed);break;
                case "D":firstChoseByMaxNeed.status=0;break;
            }

            return process(firstChoseByMaxNeed.toNode,firstChoseByMaxNeed.value+sumCost,allNeedClearRoad);
        }else {
            String type = firstChoseByUnNeed.type;
            switch (type){
                case "D":firstChoseByUnNeed.status=0;break;
            }
            return process(firstChoseByUnNeed.toNode,firstChoseByUnNeed.value+sumCost,allNeedClearRoad);

        }
    }
    public static void markEdgeCost(Node node,int cost,Set<Edge> extendEdges){
        if(node.value==1 && cost!=0){
            return;
        }
        ArrayList<Edge> inEdgesList =node.inEdges;
        cost += 1;
        for(Edge e:inEdgesList){
            Map<Edge,Integer> temMap = e.fromNode.costMap;

            Map<Edge, Set<Edge>> temEdgeGetAfterNeedEdgeMap = e.fromNode.edgeGetAfterNeedEdgeMap;
            if(temMap.containsKey(e) && temMap.get(e)>cost){
                temMap.put(e,cost);
            }else if(!temMap.containsKey(e)){
                temMap.put(e,cost);
            }

            if(temEdgeGetAfterNeedEdgeMap.containsKey(e)){
                for(Edge extendEdge:extendEdges){
                    temEdgeGetAfterNeedEdgeMap.get(e).add(extendEdge);
                }
            }else{
                Set<Edge> temEdge = new HashSet<>();
                for(Edge extendEdge:extendEdges){
                    temEdge.add(extendEdge);
                }
                temEdgeGetAfterNeedEdgeMap.put(e,temEdge);
            }
            if(e.type.equals("A") || e.type.equals("B")){
                temEdgeGetAfterNeedEdgeMap.get(e).add(e);
            }
            markEdgeCost(e.fromNode,cost,temEdgeGetAfterNeedEdgeMap.get(e));
        }
    }
}
