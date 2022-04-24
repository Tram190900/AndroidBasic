package com.example.shareprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSave = findViewById(R.id.btnSave);
        TextView tvName = findViewById(R.id.tvName);

        SharedPreferences sharedPreferences = this.getSharedPreferences("Name", Context.MODE_PRIVATE);
    }
}