package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Facce_screen extends AppCompatActivity {
    private String email;
    private String password;
    private String name;
    private int smileCount = 0;
    private int normalCount = 0;
    private int sadCount = 0;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facce_screen);
        db = new DatabaseHandler(this);

        Intent intent = getIntent();
        email = intent.getStringExtra("Email");
        password = intent.getStringExtra("Password");

        Account account = db.getAccount(email);
        name = account.getName();

        ImageButton btn_smile = findViewById(R.id.btn_Simle);
        ImageButton btn_normal = findViewById(R.id.btn_Normal);
        ImageButton btn_sad = findViewById(R.id.btn_Sad);
        Button btnFinish = findViewById(R.id.btn_Finish);

        btn_smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smileCount += 1;
            }
        });
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalCount +=1;
            }
        });
        btn_sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sadCount+=1;
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.updateSreenAccount(new Account(email, password, name, smileCount, normalCount, sadCount));
            }
        });

    }
}