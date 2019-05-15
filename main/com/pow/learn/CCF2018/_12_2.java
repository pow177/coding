package main.com.pow.learn.CCF2018;
import java.util.*;
public class _12_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] lightTimes = sc.nextLine().split(" ");
        int r = Integer.parseInt(lightTimes[0]);
        int y = Integer.parseInt(lightTimes[1]);
        int g = Integer.parseInt(lightTimes[2]);
        int dataCounts = Integer.parseInt(sc.nextLine());

        int allTimes = 0;
        for(int i = 0;i<dataCounts;i++){
            String[] tmp = sc.nextLine().split(" ");
            int type = Integer.parseInt(tmp[0]);
            int typeTime = Integer.parseInt(tmp[1]);

            if(type == 0){
                allTimes+=typeTime;
            }else if(type == 1){
                if(typeTime>=allTimes){
                    allTimes = typeTime;
                }else{
                    int moreTime = allTimes-typeTime;
                    int gToR = moreTime%(r+y+g);
                  if(gToR>=g){
                        int needTime = r+y-(gToR-g);
                        allTimes+=needTime;
                    }
                }
            }else if(type == 2){
                if(typeTime<allTimes){
                    int moreTime = allTimes-typeTime;
                    int startAtY = moreTime%(r+y+g);
                    if(startAtY<r){
                        allTimes+=r-startAtY;
                    }else if(startAtY>=r+g){
                        allTimes+=r+y-(startAtY-r-g);
                    }
                }else{
                    allTimes = r+typeTime;
                }
            }else if(type==3){
                if(typeTime<=allTimes){
                    int moreTime = allTimes-typeTime;
                    int startAtG = moreTime%(r+y+g);
                    if(startAtG<y+r){
                        allTimes+=r+y-startAtG;
                    }
                }
            }
        }
        System.out.println(allTimes);
    }
}
