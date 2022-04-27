package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Facce_screen extends AppCompatActivity {
    private String email;
    private String password;
    private String name;
    private int smileCount;
    private int normalCount;
    private int sadCount;
    private FirebaseFirestore db;
    private Account account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facce_screen);
        db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        email = intent.getStringExtra("Email");
        db.collection("Accounts").document(email)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                account = documentSnapshot.toObject(Account.class);
                smileCount = account.getSmile();
                normalCount = account.getNormal();
                sadCount = account.getSad();
            }
        });



        ImageButton btnSmile = findViewById(R.id.btn_Simle);
        ImageButton btnNormal = findViewById(R.id.btn_Normal);
        ImageButton btnSad = findViewById(R.id.btn_Sad);
        Button btnFinish = findViewById(R.id.btn_Finish);

        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sadCount = sadCount + 1;
            }
        });
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalCount += 1;
            }
        });
        btnSmile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smileCount += 1;
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Accounts").document(email)
                        .update("smile", smileCount,
                                "normal", normalCount,
                                "sad", sadCount);
                Toast.makeText(Facce_screen.this, "Finish", Toast.LENGTH_LONG).show();
            }
        });
    }
}