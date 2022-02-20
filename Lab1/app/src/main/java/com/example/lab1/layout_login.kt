package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class layout_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout2)

        var txt_forgetPW = findViewById<TextView>(R.id.txt_forgetPW)
        txt_forgetPW.setOnClickListener({
            val intent = Intent(this, layout_forgetPW::class.java)
            startActivity(intent)
        })

        var btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener({
            val intent = Intent(this,layout_Profile::class.java)
            startActivity(intent)
        })
    }
}