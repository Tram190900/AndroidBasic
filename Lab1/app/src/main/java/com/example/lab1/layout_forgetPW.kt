package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class layout_forgetPW : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_forget_pw)

        var btn_next = findViewById<Button>(R.id.btn_next);
        btn_next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, layout_code::class.java);
            startActivity(intent);
        })
    }
}