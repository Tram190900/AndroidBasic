package com.example.ongk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Donut> listDonut;
    private ListView listView;
    private List<Donut> listPinkDonut;
    private List<Donut> listFloatingDonut;
    private List<Donut> listCanTim;
    private DonutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);
        listDonut = new ArrayList<>();
        listDonut.add(new Donut(1,"Tasty Donut","Spicy donut with family","$100","Tasty"));
        listDonut.add(new Donut(2, "Pink Donut","Spicy donut with family","$100","Pink Donut"));
        listDonut.add(new Donut(3, "Floating Donut","Spicy donut with family","$100","Floating"));
        listDonut.add(new Donut(4, "Tasty Donut","Spicy donut with family","$100","Tasty"));

        adapter = new DonutAdapter(this, R.layout.item_custom_listview, listDonut);
        listView.setAdapter(adapter);

        final Button btnDonut = (Button) findViewById(R.id.btnDonut);
        final Button btnPinkDonut = (Button) findViewById(R.id.btnPinkDonut);
        final Button btnFloating = (Button) findViewById(R.id.btnFloating);
        final EditText etTim = (EditText) findViewById(R.id.tvTim);

        listPinkDonut = listTheoLoai("Pink Donut");
        DonutAdapter adapterPinkDonut = new DonutAdapter(this,R.layout.item_custom_listview,listPinkDonut);

        listFloatingDonut = listTheoLoai("Floating");
        DonutAdapter adapterFloatingDonut = new DonutAdapter(this,R.layout.item_custom_listview,listFloatingDonut);

        listCanTim = timTheoTen(etTim.getText().toString());
        DonutAdapter adapterCanTim = new DonutAdapter(this,R.layout.item_custom_listview,listCanTim);

        btnDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnDonut.isClickable()){
                    listView.setAdapter(adapter);
                }

            }
        });
        btnPinkDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnPinkDonut.isClickable()){
                    listView.setAdapter(adapterPinkDonut);
                }
            }
        });
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnFloating.isClickable()){
                    listView.setAdapter(adapterFloatingDonut);
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
    private List<Donut> listTheoLoai(String loai){
        List<Donut> kq = new ArrayList<>();
        for (Donut donut: listDonut) {
            if (donut.getLoai()==loai)
                kq.add(donut);
        }
        return kq;
    }
    private List<Donut> timTheoTen(String tenBanh){
        List<Donut> kq = new ArrayList<>();
        for (Donut donut: listDonut) {
            if (donut.getLoai()==tenBanh)
                kq.add(donut);
        }
        return kq;
    }
}