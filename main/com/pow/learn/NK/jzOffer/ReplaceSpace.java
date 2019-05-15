package main.com.pow.learn.NK.jzOffer;

public class ReplaceSpace {
    public static void main(String[] args){
        ReplaceSpace r = new ReplaceSpace();
       String result =  r.replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(result);
    }
    public String replaceSpace(StringBuffer str) {
       return str.toString().replaceAll(" ","%20");
    }
}
