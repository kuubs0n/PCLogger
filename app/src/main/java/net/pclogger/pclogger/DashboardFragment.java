package net.pclogger.pclogger;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import net.pclogger.pclogger.ApiModels.ApiConnection;
import net.pclogger.pclogger.ApiModels.UserDailyStatsModel;
import net.pclogger.pclogger.ApiModels.UserDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j.krawczyk on 06.09.2017.
 */

public class DashboardFragment extends Fragment {

    private ListView lvUsers;
    private ProgressDialog _progressDialog;
    private List<UserDataModel> _activeUsers;
    private UserDataModel[] _users;
    private List<UserDailyStatsModel> _dailyStats;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        new prepareChartAsync().execute();
    }

    public class prepareChartAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute(){
            _progressDialog = new ProgressDialog(getActivity());
            _progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            _progressDialog.setIndeterminate(true);
            _progressDialog.setMessage("Pobieranie danych...");;
            _progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... args0){
            try{
                _users = ApiService.getUsers();
                ApiService.getDailyUsersEfficiency();
                //_dailyStats = ApiService.getDailyUsersStats();
            }catch(Exception ex){
                Log.e("API", ex.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            _progressDialog.dismiss();
            prepareListView(getView());
            prepareActiveChart(getView());
        }
    }

    private void prepareListView(View view){
        lvUsers = (ListView) view.findViewById(R.id.lvUsers);
        UserArrayAdapter adapter = new UserArrayAdapter(getActivity(), _users);
        lvUsers.setAdapter(adapter);

        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "DUPA", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void prepareActiveChart(View view) {

        /*List<PieEntry> entriesActive = new ArrayList<PieEntry>();
        int unactive = _users.size() - _activeUsers.size();
        entriesActive.add(new PieEntry(_activeUsers.size(), "Aktywni"));
        entriesActive.add(new PieEntry(unactive, "Nieaktywni"));

        PieDataSet pieDataSetActive = new PieDataSet(entriesActive, "Aktywni użytkownicy");
        pieDataSetActive.setDrawValues(false);
        pieDataSetActive.setColors(new int[] {getResources().getColor(R.color.colorGreen), getResources().getColor(R.color.colorRed)});

        PieData pieData = new PieData(pieDataSetActive);
        pieData.setHighlightEnabled(true);

        PieChart pieChart = (PieChart)view.findViewById(R.id.pieChart);
        pieChart.getLegend().setEnabled(false);
        pieChart.setDrawSliceText(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setMaxAngle(180f);
        pieChart.setTouchEnabled(false);
        pieChart.setRotationEnabled(false);
        pieChart.setData(pieData);
        pieChart.invalidate();*/
    }

}
