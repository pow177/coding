package main.com.pow.learn.CCF2018;

        import java.util.Scanner;
public class _12_2_B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] lightTimes = sc.nextLine().split(" ");
        long r = Long.parseLong(lightTimes[0]);
        long y = Long.parseLong(lightTimes[1]);
        long g = Long.parseLong(lightTimes[2]);
        long dataCounts = Long.parseLong(sc.nextLine());

        long allTimes = 0;
        for(int i = 0;i<dataCounts;i++){
            String[] tmp = sc.nextLine().split(" ");
            long type = Long.parseLong(tmp[0]);
            long typeTime = Long.parseLong(tmp[1]);

            long moveTime = allTimes%(r+y+g);
            if(type==0){
                allTimes+=typeTime;
            }else if(type == 1){
                if(moveTime<typeTime){
                    allTimes+=typeTime-moveTime;
                }else if(moveTime>=typeTime+g){
                    long needTime = y+r-(moveTime-typeTime-g);
                    allTimes+=needTime;
                }
            }else if(type == 2){
                if(moveTime<typeTime+r){
                    allTimes+=typeTime+r-moveTime;
                }else if(moveTime>=typeTime+r+g){
                    allTimes+=r+y-(moveTime-typeTime-r-g);
                }
            }else if(type == 3){
                if(moveTime>=typeTime && moveTime<r+y+typeTime){
                    allTimes+=r+y-(moveTime-typeTime);
                }
            }
        }
        System.out.println(allTimes);
    }
}
