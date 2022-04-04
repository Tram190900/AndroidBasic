package com.example.lab7_listtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Travel> listTravel;
    private AdapterTravel adapterTravel;
    private DatabaseHandler db;
    private ListView lvTravel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);

        lvTravel = findViewById(R.id.lv_Travel);
        listTravel = new ArrayList<>();
        listTravel = db.getAllTravels();
        adapterTravel = new AdapterTravel(this,R.layout.item_travel, listTravel);
        lvTravel.setAdapter(adapterTravel);
        Button btnSave = findViewById(R.id.btnSave);
        TextView tvName = findViewById(R.id.tv_travel);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addTravel(new Travel(tvName.getText().toString()));
                loadListView();
            }
        });


    }
    private void loadListView(){
        List<Travel> list = new ArrayList<>();
        list = db.getAllTravels();
        adapterTravel = new AdapterTravel(this, R.layout.item_travel,list);
        lvTravel.setAdapter(adapterTravel);
    }
}