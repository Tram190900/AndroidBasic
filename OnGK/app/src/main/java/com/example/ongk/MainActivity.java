package com.example.ongk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<Donut> listDonut;
    private ListView listView;
    private DonutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);
        listDonut = new ArrayList<>();
        listDonut.add(new Donut(R.drawable.donut_yellow_1,"Tasty Donut","Tasty donut with family","$100","Tasty"));
        listDonut.add(new Donut(R.drawable.donut_red_1, "Pink Donut","Pink donut with family","$130","Pink Donut"));
        listDonut.add(new Donut(R.drawable.green_donut_1, "Floating Donut","Floating donut with family","$200","Floating"));
        listDonut.add(new Donut(R.drawable.tasty_donut_1, "Tasty Donut","Spicy donut with family","$100","Tasty"));

        inDanhSach();

        final Button btnDonut = (Button) findViewById(R.id.btnDonut);
        final Button btnPinkDonut = (Button) findViewById(R.id.btnPinkDonut);
        final Button btnFloating = (Button) findViewById(R.id.btnFloating);
        final EditText edTim = (EditText) findViewById(R.id.tvTim);




        btnDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnDonut.isClickable()){
                   inDanhSach();
                }

            }
        });
        btnPinkDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnPinkDonut.isClickable()){
//                    getSupportFragmentManager().beginTransaction()
//                            .setReorderingAllowed(true)
//                            .add(R.id.blankFragment,BlankFragment.class,null)
//                            .commit();
                   listTheoLoai("Pink Donut");
                }
            }
        });
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnFloating.isClickable()){
                   listTheoLoai("Floating");
                }
            }
        });
        edTim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().equals("")){
                    // reset listview
                    inDanhSach();
                } else {
                    // perform search
                    timTheoTen(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void inDanhSach(){
        adapter = new DonutAdapter(this, R.layout.item_custom_listview, listDonut);
        listView.setAdapter(adapter);
    }
    private void listTheoLoai(String loai){
        List<Donut> kq = new ArrayList<>();
        for (Donut donut: listDonut) {
            if (donut.getLoai()==loai)
                kq.add(donut);
        }
        adapter = new DonutAdapter(this,R.layout.item_custom_listview,kq);
        listView.setAdapter(adapter);
    }
    private void timTheoTen(String tenBanh){
        List<Donut> kq = new ArrayList<>();
        for(Donut item:listDonut){
            if(item.getTen().toLowerCase().equals(tenBanh)){
                kq.add(item);
            }
        }
        adapter = new DonutAdapter(this,R.layout.item_custom_listview,kq);
        listView.setAdapter(adapter);
    }
}