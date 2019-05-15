package main.com.pow.learn.CCF2017;

import java.util.*;

public class _09_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String scStr1 = sc.nextLine();
        int N = Integer.parseInt(scStr1.split(" ")[0]);
        int K = Integer.parseInt(scStr1.split(" ")[1]);
        int[] findPlaceByKey = new int[N+1];   //根据钥匙找到位置
        int[] findKeyByPlace = new int[N+1];    //根据位置找到钥匙
        PriorityQueue<Integer> placeHead = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        PriorityQueue<Obj> startHead = new PriorityQueue<>(new Comparator<Obj>() {
            @Override
            public int compare(Obj o1, Obj o2) {
                return o1.startTime-o2.startTime;
            }
        });
        PriorityQueue<Obj> endHead = new PriorityQueue<>(new Comparator<Obj>() {
            @Override
            public int compare(Obj o1, Obj o2) {
                if(o1.endTime>o2.endTime){
                    return 1;
                }else if(o1.endTime<o2.endTime){
                    return -1;
                }else {
                    return o1.value-o2.value;
                }
            }
        });
        for(int i=1;i<=N;i++){//初始化钥匙盒子
            findPlaceByKey[i] = i;
            findKeyByPlace[i] = i;
        }
        for(int i=0;i<K;i++){
            scStr1 = sc.nextLine();
            int value = Integer.parseInt(scStr1.split(" ")[0]);
            int start = Integer.parseInt(scStr1.split(" ")[1]);
            int keep = Integer.parseInt(scStr1.split(" ")[2]);
            Obj obj = new Obj(value,start,start+keep);
            startHead.add(obj);
            endHead.add(obj);
        }

        while (!endHead.isEmpty()){
            Obj putKey = endHead.peek();

            Obj curKey = startHead.peek();  //取出最先开始的
              if(curKey!=null) {
                  if (putKey.endTime > curKey.startTime) {
                      startHead.poll(); //消费一个
                      placeHead.add(findPlaceByKey[curKey.value]); //当前有一个空位进堆。
                      findKeyByPlace[findPlaceByKey[curKey.value]] = 0;     //位置上对应的钥匙也为0；
                      findPlaceByKey[curKey.value] = 0;     //钥匙取出来了，设置为0

                  } else if (putKey.endTime == curKey.startTime) {
                      //先放后取。
                      //放
                      endHead.poll();    //取出一个放钥匙的动作
                      int place = placeHead.poll();    //堆取出最左边的位置
                      findKeyByPlace[place] = putKey.value;
                      findPlaceByKey[putKey.value] = place;
                      //取
                      startHead.poll(); //消费一个
                      placeHead.add(findPlaceByKey[curKey.value]); //当前有一个空位进堆。
                      findKeyByPlace[findPlaceByKey[curKey.value]] = 0;     //位置上对应的钥匙也为0；
                      findPlaceByKey[curKey.value] = 0;     //钥匙取出来了，设置为0
                  } else if (putKey.endTime < curKey.startTime) {
                      //放
                      endHead.poll();    //取出一个放钥匙的动作
                      int place = placeHead.poll();    //堆取出最左边的位置
                      findKeyByPlace[place] = putKey.value;
                      findPlaceByKey[putKey.value] = place;
                  }
              }else {   //钥匙取尽了，只有放回去的操作
                  //放
                  endHead.poll();    //取出一个放钥匙的动作
                  int place = placeHead.poll();    //堆取出最左边的位置
                  findKeyByPlace[place] = putKey.value;
                  findPlaceByKey[putKey.value] = place;
              }


        }
        for(int i=1;i<=N;i++) {
            System.out.print(findKeyByPlace[i]+" ");
        }
    }

    public static class Obj{
        int value;
        int startTime;
        int endTime;
        public Obj(int value,int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
            this.value = value;
        }
    }
}
