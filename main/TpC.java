package main;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TpC {
    public static void main(String[] args) {
        HttpPost httpPost = new HttpPost("https://123m.ldygo.com/los/zuche-intf-login.graphicTokenImg?_channel_id=01");
        HttpResponse httpresponse = null;
        HttpClient httpClient = HttpClients.createDefault();
        try {
            httpresponse = httpClient.execute(httpPost);
            HttpEntity entity = httpresponse.getEntity();
            InputStream inputStream = entity.getContent();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String content = bufferedReader.readLine();
                System.out.println(content);
        }catch (Exception e){
            System.out.println("error  "+e);
        }
        }
}
