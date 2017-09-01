package net.pclogger.pclogger;

import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.loopj.android.http.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import javax.net.ssl.HttpsURLConnection;

import IPclLicenseServiceContract.UserAccountModel;

/**
 * Created by j.krawczyk on 01.09.2017.
 */

public class ApiService {
    private static final String PCLOGGER_LOGIN_URL = "https://admin.pclogger.net/Account/Login";

    private static String getRequestVerificationToken(){
        Document loginBody = null;
        try {
            loginBody = Jsoup.connect(PCLOGGER_LOGIN_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
                    .get();
        } catch (IOException e) {
            Log.e("API", e.getMessage());
        }
        Element inputToken = loginBody.select("input[name=__RequestVerificationToken]").first();
        String tokenValue = inputToken.attr("value");
        return tokenValue;
    }

    public static void getUserCookies(){
        String tokenValue = getRequestVerificationToken();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(PCLOGGER_LOGIN_URL);
        try{
            List nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("__RequestVerificationToken", tokenValue));
            nameValuePairs.add(new BasicNameValuePair("UserName", "reiter@pclogger.net"));
            nameValuePairs.add(new BasicNameValuePair("Password", "Marzenka123"));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            Header[] cookies = response.getAllHeaders();
            String as = "as";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (org.apache.http.client.ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
