package com.example.lab6_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    Fragment_Above above = new Fragment_Above();
    Fragment_Bloew below = new Fragment_Bloew();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.frm_above,above,null)
                .commit();
        fm.beginTransaction()
                .add(R.id.frm_below,below,null)
                .commit();

    }
}