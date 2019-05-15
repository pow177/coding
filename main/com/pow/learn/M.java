package main.com.pow.learn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    爬取的资源会放在D盘下的html_resources文件夹

 */
public class M {
            public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入要爬取的网站地址：");
                int pageNum = 1;
                int start = 1;
                String getLink = sc.next();
                System.out.println("请输入开始页数：");
                start = sc.nextInt();
                pageNum = start;
                try
                {
                    for(int iout=start;iout<=pageNum;iout++) {
                        Document document = Jsoup.connect(getLink+"&page="+iout).get();
                        Elements links = document.select("a[href]");
                        Elements num = document.select("font[color='red']");
                        if(iout==start) {
                            pageNum = Integer.parseInt(num.get(3).html());
                            System.out.println(pageNum);
                        }
                        for (Element link : links) {
                            if (link.attr("href").indexOf("cssthemes") > 0 && link.text().length() > 5) {
//                                System.out.println("link : " + link.attr("href"));
                                System.out.println("text : " + link.text());
                                Document d2 = Jsoup.connect("http://www.cssmoban.com" + link.attr("href")).get();
                                Elements l2 = d2.select(".btn-down");

                                for (Element l : l2) {
                                    System.out.println(l);

                                    //下载图片
                                    try {
                                        //创建文件目录
                                        File files = new File("D:\\html_resources");
                                        if (!files.exists()) {
                                            files.mkdirs();
                                        }
                                        //获取下载地址
                                        URL url = new URL(l.attr("href"));
                                        //链接网络地址
                                        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                                        //获取链接的输出流
                                        InputStream is = connection.getInputStream();
                                        //创建文件，fileName为编码之前的文件名
                                        File file = new File("D:\\html_resources\\" + link.text()+".zip");
                                        //根据输入流写入文件
                                        FileOutputStream out = new FileOutputStream(file);
                                        int i = 0;
                                        while((i = is.read()) != -1){
                                            out.write(i);
                                        }
                                        out.close();
                                        is.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        }

                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }


}
