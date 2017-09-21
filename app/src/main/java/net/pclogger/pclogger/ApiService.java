package net.pclogger.pclogger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.pclogger.pclogger.ApiModels.ApiConnection;
import net.pclogger.pclogger.ApiModels.UserDailyStatsModel;
import net.pclogger.pclogger.ApiModels.UserDataModel;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by j.krawczyk on 01.09.2017.
 */

public class ApiService {

    private static final String PCLOGGER_GET_USERS = "https://admin.pclogger.net/Api/Users/GetUsers";
    private static final String PCLOGGER_GET_ACTIVE_USERS = "https://admin.pclogger.net/Api/Users/GetActiveUsers";
    private static final String PCLOGGER_GET_EFFICIENCY_FOR_ORGANIZATION = "https://admin.pclogger.net/api/EfficiencyStatistics/GetForOrganization/?date=2017-09-21T00:00:00.000Z";
    private static final String PCLOGGER_GET_DAILY_USERS_STATS = "https://admin.pclogger.net/api/users/GetDailyUsersStats?date=2017-09-21T00:00:00.000Z";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

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
            Date todaysDate = new Date();
            String stringDate = DATE_FORMAT.format(todaysDate) + "T00:00:00.000Z";
            HttpResponse response = client.execute(new HttpGet(PCLOGGER_GET_ACTIVE_USERS + "/date=" + stringDate));
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

    public static String getEfficiencyForOrganization(){
        HttpClient client = ApiConnection.getApiClient();
        try{
            HttpResponse response = client.execute(new HttpGet(PCLOGGER_GET_EFFICIENCY_FOR_ORGANIZATION));
            String results = EntityUtils.toString(response.getEntity(), "UTF-8");
            return results;
        } catch(ClientProtocolException e){

        } catch(IOException e){

        }
        return null;
    }

    public static List<UserDailyStatsModel> getDailyUsersStats(){
        HttpClient client = ApiConnection.getApiClient();
        try{
            HttpResponse response = client.execute(new HttpGet(PCLOGGER_GET_DAILY_USERS_STATS));
            String results = EntityUtils.toString(response.getEntity(), "UTF-8");

            Type type = new TypeToken<List<UserDailyStatsModel>>(){}.getType();
            List<UserDailyStatsModel> usersDailyStats = new Gson().fromJson(results, type);
            String asd = "123";
            return usersDailyStats;
        } catch(ClientProtocolException e){

        } catch(IOException e){

        }
        return null;
    }
}
