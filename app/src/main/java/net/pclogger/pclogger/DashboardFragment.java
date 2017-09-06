package net.pclogger.pclogger;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import net.pclogger.pclogger.ApiModels.ApiConnection;
import net.pclogger.pclogger.ApiModels.UserDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j.krawczyk on 06.09.2017.
 */

public class DashboardFragment extends Fragment {

    private ProgressDialog _progressDialog;
    private List<UserDataModel> _activeUsers;
    private List<UserDataModel> _users;

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
                //_activeUsers = ApiService.getActiveUsers();
            }catch(Exception ex){
                Log.e("API", ex.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            _progressDialog.dismiss();
            prepareActiveChart(getView());
        }
    }

    private void prepareActiveChart(View view) {

        List<PieEntry> entriesActive = new ArrayList<PieEntry>();
        entriesActive.add(new PieEntry(_users.size(), "Aktywni"));
        entriesActive.add(new PieEntry(_users.size() - 2f, "Nieaktywni"));

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
        pieChart.invalidate();
    }

}
