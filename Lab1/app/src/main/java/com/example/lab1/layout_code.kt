package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class layout_code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_code)
    var btn_code = findViewById<Button>(R.id.btn_code);
        btn_code.setOnClickListener({
            val intent = Intent(this, layout_pw_generator::class.java)
            startActivity(intent)
        })
    }
}