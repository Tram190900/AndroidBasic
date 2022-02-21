package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_login = findViewById<Button>(R.id.btn_login)
        var user = findViewById<EditText>(R.id.txt_userName)
        var password = findViewById<EditText>(R.id.txt_password)
        val listenerLoginButton = View.OnClickListener { view ->
                if(user.getText().toString().equals("tram") && password.getText().toString().equals("190900")){
                    val intent = Intent(this,Layout_Comment::class.java)
                    startActivity(intent)
                }
                else {
                    user.setText("")
                    password.setText("")
                    Toast.makeText(view.context, "Đăng nhập không thành công!!!", Toast.LENGTH_SHORT)
                        .show()
                    }
        }
        btn_login.setOnClickListener(listenerLoginButton)
    }
}