package net.pclogger.pclogger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.pclogger.pclogger.ApiModels.ApiConnection;
import net.pclogger.pclogger.ApiModels.UserDataModel;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by j.krawczyk on 01.09.2017.
 */

public class ApiService {

    private static final String PCLOGGER_GET_USERS = "https://admin.pclogger.net/Api/Users/GetUsers";
    private static final String PCLOGGER_GET_ACTIVE_USERS = "https://admin.pclogger.net/Api/Users/GetActiveUsers";

    public static List<UserDataModel> getUsers(){
        HttpClient client = ApiConnection.getApiClient();
        try {
            HttpResponse response = client.execute(new HttpGet(PCLOGGER_GET_USERS));
            String results = EntityUtils.toString(response.getEntity(), "UTF-8");

            Type type = new TypeToken<List<UserDataModel>>(){}.getType();
            List<UserDataModel> getUserResults = new Gson().fromJson(results, type);
            return getUserResults;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<UserDataModel> getActiveUsers(){
        HttpClient client = ApiConnection.getApiClient();
        try{
            HttpResponse response = client.execute(new HttpGet(PCLOGGER_GET_ACTIVE_USERS));
            String results = EntityUtils.toString(response.getEntity(), "UTF-8");

            Type type = new TypeToken<List<UserDataModel>>(){}.getType();
            List<UserDataModel> getActiveUserResults = new Gson().fromJson(results, type);
            return getActiveUserResults;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
