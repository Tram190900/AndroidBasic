package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        var btn_login = findViewById<Button>(R.id.btn_login);
        btn_login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, layout_login::class.java);
            startActivity(intent);
        })

        var btn_signup = findViewById<Button>(R.id.btn_signup);
        btn_signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, layout_signup::class.java);
            startActivity(intent);
        })


    }

}