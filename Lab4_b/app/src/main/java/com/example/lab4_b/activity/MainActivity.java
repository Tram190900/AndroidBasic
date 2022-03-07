package com.example.lab4_b.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.lab4_b.R;
import com.example.lab4_b.adapter.ElectronicItemAdapter;
import com.example.lab4_b.model.ElectronicItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private List<ElectronicItem> lstElectronicItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.idGridView);

        lstElectronicItem = new ArrayList<>();
        lstElectronicItem.add(new ElectronicItem(1,"Cáp chuyển cổng từ USB sang SP2...","(13)","69.900 đ","-39%"));
        lstElectronicItem.add(new ElectronicItem(2,"Cáp chuyển cổng từ USB sang SP2...","(13)","69.900 đ","-39%"));
        lstElectronicItem.add(new ElectronicItem(3,"Cáp chuyển cổng từ USB sang SP2...","(13)","69.900 đ","-39%"));
        lstElectronicItem.add(new ElectronicItem(4,"Cáp chuyển cổng từ USB sang SP2...","(13)","69.900 đ","-39%"));
        lstElectronicItem.add(new ElectronicItem(5,"Cáp chuyển cổng từ USB sang SP2...","(13)","69.900 đ","-39%"));
        lstElectronicItem.add(new ElectronicItem(6,"Cáp chuyển cổng từ USB sang SP2...","(13)","69.900 đ","-39%"));

        ElectronicItemAdapter adapter = new ElectronicItemAdapter(this, R.layout.item_custom_grid_view,lstElectronicItem);
        gridView.setAdapter(adapter);
    }
}