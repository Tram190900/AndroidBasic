package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SignActivity extends AppCompatActivity {
    private DatabaseHandler db;
    private List<Account> lstAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        db = new DatabaseHandler(this);

        Button btn_face = findViewById(R.id.btn_Signin);
        TextView tv_Email = findViewById(R.id.txtEmail);
        TextView tv_Password = findViewById(R.id.txtPassword);
        btn_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lstAccount = db.getAllAccount();
                for (Account acc: lstAccount) {
                    if (tv_Email.getText().toString().equals(acc.geteMail()) && tv_Password.getText().toString().equals(acc.getPassword())) {
                        Intent intent = new Intent(SignActivity.this, Facce_screen.class);
                        intent.putExtra("Email", tv_Email.getText().toString());
                        intent.putExtra("Password", tv_Password.getText().toString());
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(SignActivity.this,"Email không tồn tại",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}