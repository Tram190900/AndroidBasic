package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class SignActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        auth = FirebaseAuth.getInstance();

        Button btn_face = findViewById(R.id.btn_Signin);
        TextView tv_Email = findViewById(R.id.txtEmail);
        TextView tv_Password = findViewById(R.id.txtPassword);
        btn_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signInWithEmailAndPassword(tv_Email.getText().toString(), tv_Password.getText().toString())
                        .addOnCompleteListener(SignActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(SignActivity.this, Facce_screen.class);
                                    intent.putExtra("Email", tv_Email.getText().toString());
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(SignActivity.this, "Email không tồn tại", Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });

    }
}