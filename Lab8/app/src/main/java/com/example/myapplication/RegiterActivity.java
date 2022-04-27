package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.IOException;

public class RegiterActivity extends AppCompatActivity {
    //private ActivityStorageBinding binding;
    private Uri imageURI;
    private FirebaseAuth auth;
    private FirebaseFirestore db;
    private File imageFile;
    private int PICK_IMAGE_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        TextView tvEmail = findViewById(R.id.txtEmail_Register);
        TextView tvName = findViewById(R.id.txtName_Regiter);
        TextView tvPW = findViewById(R.id.txtPassword_Register);
        TextView tvPW_cf = findViewById(R.id.txt_ConfirmPS);


        Button btnRegister = findViewById(R.id.btn_Register);
        Button btnImg = findViewById(R.id.btn_getImg);


        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                //startActivityForResult(Intent.createChooser(intent, "Select a photo"), PICK_IMAGE_REQUEST);
                startActivityForResult(intent,100);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(tvEmail.getText().length() > 0 && tvName.getText().length()  > 0
//                        && tvPW.getText().length() > 0 && tvPW_cf.getText().equals(tvPW.getText())){
                    String email = tvEmail.getText().toString();
                    String name = tvName.getText().toString();
                    String password = tvPW_cf.getText().toString();

                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegiterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegiterActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                                        Account account = new Account(email, name, password, 0, 0, 0);
                                        db.collection("Accounts").document(account.geteMail()).set(account);
                                    }
                                }
                            });
//                  }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView _imgImage = findViewById(R.id.img);
        if(requestCode==0){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");//image bitmap file
            Bitmap resizeBitmap = Bitmap.createScaledBitmap(bitmap,680,500,false);
            _imgImage.setImageBitmap(resizeBitmap);
        }
        else if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                //ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap resizeBitmap = Bitmap.createScaledBitmap(bitmap,680,500,false);
                _imgImage.setImageBitmap(resizeBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        if(requestCode == 100 && data != null && data.getData() != null){
//            imageURI = data.getData();
//            binding.imageViewWallpaper.setImageURI(imageURI);
//        }

    }
}