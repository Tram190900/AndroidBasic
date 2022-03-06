package com.example.lab3_c

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnMau = findViewById<Button>(R.id.btnChonMau);
        btnMau.setOnClickListener (View.OnClickListener {
            val intent = Intent(this, ChonMauActivity::class.java)
            startActivity(intent)
        })
    }

}