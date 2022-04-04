package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterNAme adapterNAme;
    private List<Name> listName;
    private DatabaseHandler db;
    private ListView lvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);

        lvName = findViewById(R.id.lv_Name);
        listName = new ArrayList<>();
        listName = db.getAllNames();
        adapterNAme = new AdapterNAme(this, R.layout.item,listName);
        lvName.setAdapter(adapterNAme);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);
        TextView tvPushName = findViewById(R.id.txtPushNamw);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addName(new Name(tvPushName.getText().toString()));
                loadListView();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    db.deleteName(new Name(tvPushName.getText().toString()));
                    loadListView();
            }
        });
    }
    private void loadListView(){
        List<Name> lst = new ArrayList<>();
        lst = db.getAllNames();
        adapterNAme = new AdapterNAme(this,R.layout.item, lst);
        lvName.setAdapter(adapterNAme);
    }
}