package net.pclogger.pclogger.ApiModels;

import net.pclogger.pclogger.ApiService;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j.krawczyk on 06.09.2017.
 */

public class ApiConnection {
    private static HttpClient httpClient;
    private static final String PCLOGGER_LOGIN_URL = "https://admin.pclogger.net/Account/Login";

    public static boolean initApi(String email, String password){
        httpClient = null;
        httpClient = getUserSession(email, password);
        if(httpClient != null)
            return true;
        return false;
    }

    public static HttpClient getApiClient(){
        return httpClient;
    }


    private static boolean clientHasSession(){
        return true;
    }

    private static HttpClient getUserSession(String email, String password) {

        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(PCLOGGER_LOGIN_URL);
        try {
            HttpResponse getResponse = client.execute(httpGet);
            String responseString = EntityUtils.toString(getResponse.getEntity(), "UTF-8");
            Header[] cookies = getResponse.getHeaders("Set-Cookie");

            HttpPost httpPost = new HttpPost(PCLOGGER_LOGIN_URL);
            for(Header header : cookies) {
                httpPost.setHeader(header);
            }

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("UserName", email));
            nameValuePairs.add(new BasicNameValuePair("Password", password));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse postResponse = client.execute(httpPost);

            return client;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
