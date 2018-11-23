package com.bcu.londonappbrewery.climate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter<HistoryObj> {
    ArrayList<HistoryObj> historyList = new ArrayList<>();
    public HistoryAdapter(Context context, ArrayList<HistoryObj> historyList) {
        super(context, 0, historyList);
        this.historyList = historyList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.history_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.name_tv);
        TextView tvTemprature = (TextView) convertView.findViewById(R.id.temprature_tv);
        TextView tvDate = (TextView) convertView.findViewById(R.id.date_tv);

        tvName.setText(historyList.get(position).getName());
        tvTemprature.setText(historyList.get(position).getTemprature());
        tvName.setText(historyList.get(position).getName());
        tvDate.setText(historyList.get(position).getTime());
        // Return the completed view to render on screen
        return convertView;
    }
}
