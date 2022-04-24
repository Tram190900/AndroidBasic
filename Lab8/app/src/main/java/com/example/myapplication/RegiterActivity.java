package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegiterActivity extends AppCompatActivity {
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);
        db = new DatabaseHandler(this);

        TextView tvEmail = findViewById(R.id.txtEmail_Register);
        TextView tvName = findViewById(R.id.txtName_Regiter);
        TextView tvPW = findViewById(R.id.txtPassword_Register);
        TextView tvPW_cf = findViewById(R.id.txt_ConfirmPS);

        Button btnRegister = findViewById(R.id.btn_Register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(tvEmail.getText().length() > 0 && tvName.getText().length()  > 0
//                        && tvPW.getText().length() > 0 && tvPW_cf.getText().equals(tvPW.getText())){
                    String email = tvEmail.getText().toString();
                    String name = tvName.getText().toString();
                    String password = tvPW_cf.getText().toString();
                    Account account = new Account(email, name, password, 0, 0, 0);
                    db.addAccount(account);

                    Toast.makeText(RegiterActivity.this,"Thêm thành công", Toast.LENGTH_LONG).show();

//                }
            }
        });

    }
}