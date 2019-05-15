package main.com.pow.learn.CCF20180901;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _09_02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int counts = Integer.parseInt(sc.nextLine());
        List<MapTo> mapTos = new ArrayList<>();
        for(int i=0;i<counts;i++){
            String tmp = sc.nextLine();
            mapTos.add(new MapTo(Integer.parseInt(tmp.split(" ")[0]),Integer.parseInt(tmp.split(" ")[1])));
        }
        long result = 0;
        for(int i = 0;i<counts;i++){
            String tmp = sc.nextLine();
            int s = Integer.parseInt(tmp.split(" ")[0]);
            int e = Integer.parseInt(tmp.split(" ")[1]);
            for(MapTo m:mapTos){
                if(s>=m.start && e<=m.end){
                    result+=e-s;
                }else if(s>=m.start && s<m.end && e>m.end){
                    result+=m.end-s;
                }else if(s<m.start && e>m.start && e<=m.end){
                    result+=e-m.start;
                }else if(s<m.start && e>m.end){
                    result+=m.end-m.start;
                }
            }
        }
        System.out.println(result);
    }
    public static class MapTo{
        int start;
        int end;
        public MapTo(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}
