package com.example.lab6_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShoesFragment shoesFragment = new ShoesFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frmShoes,shoesFragment,null).commit();
    }
}