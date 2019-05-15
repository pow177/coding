package main.com.pow.learn;

public class UnionFind {
    private int[] parent; //parentb[i]表示第一个元素所指向的父节点
    private int count; //数据个数
    private int[] size; //当前根下的元素个数

    public UnionFind(int n){
        this.parent = new int[n];
        this.size = new int[n];
        this.count = n;
        for(int j=0;j<n;j++){
            this.parent[j] = j;
            this.size[j] = 1;
        }
    }


    /**
     * 找出根节点
     * @param i
     * @return
     */
    public int find(int i){
        if(i>=count || i<0){
            return i;
        }
        while(parent[i]!=i){
            i = parent[i];
        }
        return i;
    }

    public void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB){
            return;
        }
        if(size[rootA]>size[rootB]) {
            parent[rootB] = rootA;
            size[rootA]+=size[rootB];
        }else {
            parent[rootA] = rootB;
            size[rootB]+=size[rootA];
        }

    }

    public boolean isSameSet(int a,int b){
        if(a==b){
            return true;
        }else{
            return find(a)==find(b);
        }
    }

    public static void main(String[] args){
       UnionFind unionFind = new UnionFind(10);
        boolean b1 = unionFind.isSameSet(1,3);   //false
        System.out.println(b1);
        System.out.println(unionFind.size[3]);//1
        unionFind.union(1,3);
        System.out.println(unionFind.size[3]);//2

        unionFind.union(1,4);
        System.out.println(unionFind.size[3]);//3

        unionFind.union(5,6);


        System.out.println(unionFind.size[6]); //2
         b1 = unionFind.isSameSet(1,3);     //true
        System.out.println(b1);
        unionFind.union(1,6);
         b1 = unionFind.isSameSet(1,6);     //true
        System.out.println(b1);
        int re = unionFind.find(5);
        System.out.println(re);  //3
    }
}
