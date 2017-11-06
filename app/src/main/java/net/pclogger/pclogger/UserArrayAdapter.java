package net.pclogger.pclogger;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.pclogger.pclogger.ApiModels.UserDataModel;

/**
 * Created by Kuubs0n on 2017-11-02.
 */

public class UserArrayAdapter extends ArrayAdapter<UserDataModel> {
    private Activity context;
    private UserDataModel[] users;

    public UserArrayAdapter(Activity context, UserDataModel[] users){
        super(context, R.layout.list_item_dashboard, users);
        this.context = context;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowView = convertView;
        if(rowView == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            rowView =  layoutInflater.inflate(R.layout.list_item_dashboard, null, true);
        }

        TextView tvUserName = (TextView) rowView.findViewById(R.id.tvUserName);
        ImageView ivUserActivity = (ImageView) rowView.findViewById(R.id.ivActivity);

        tvUserName.setText(users[position].FullName);
        if(position % 2 == 0)
            ivUserActivity.setImageResource(R.drawable.greenico);
        else
            ivUserActivity.setImageResource(R.drawable.redico);

        return rowView;
    }

}
