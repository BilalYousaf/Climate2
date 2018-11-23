package com.bcu.londonappbrewery.climate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {
    ListView listView;
    SaveData saveData;
    ImageButton backImageBtn;
    private static String TAG = "HistoryActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);
        Log.d(TAG, "onCreate: ");

        listView = findViewById(R.id.history_listview);
        backImageBtn = findViewById(R.id.backImageButton);

        Log.d(TAG, "onCreate: SaveData.weatherHistoryList.size():"+SaveData.weatherHistoryList.size());
        saveData = new SaveData(this);
        if(SaveData.weatherHistoryList != null) {
            setListviewAdapter();
        }

        backImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    void setListviewAdapter(){
        Log.d(TAG, "setListviewAdapter: ");
// Create the adapter to convert the array to views
        HistoryAdapter adapter = new HistoryAdapter(this, SaveData.weatherHistoryList);
// Attach the adapter to a ListView
        listView.setAdapter(adapter);
    }
}
