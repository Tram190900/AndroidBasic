package com.example.lab9_storage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnAdd) Button btnAdd;
    @BindView(R.id.btnImage) Button btnSelectImg;
    @BindView(R.id.btnRemove) Button btnRemove;
    @BindView(R.id.txtPushNamw) EditText tvPushName;
    @BindView(R.id.txtID) EditText tvID;
    @BindView(R.id.lv_Name) ListView lvName;
    @BindView(R.id.imageSelect) ImageView imgName;


    private static final int PICK_IMAGE_REQUEST = 1;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private final StorageReference storageRef = storage.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadListView();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Upload image and get link
                Calendar calendar = Calendar.getInstance();
                String pushName = tvPushName.getText().toString();
                // Create a reference to "mountains.jpg"
                StorageReference mountainsRef = storageRef.child(tvPushName.getText().toString() + ".png");

                // Create a reference to 'images/mountains.jpg'
                StorageReference mountainImagesRef = storageRef.child("images/"+tvPushName.getText().toString()+".png");

                mountainsRef.getName().equals(mountainImagesRef.getName());    // true
                mountainsRef.getPath().equals(mountainImagesRef.getPath());

                imgName.setDrawingCacheEnabled(true);
                imgName.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imgName.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@android.support.annotation.NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> result = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                        result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String photoLink = uri.toString();
                                int id = Integer.parseInt(tvID.getText().toString());
                                //Toast.makeText(SignUpActivity.this, photoLink, Toast.LENGTH_SHORT).show();
                                //we will store the additional fields in firebase database
                                Name name = new Name(id,photoLink, pushName);
                                db.collection("names").document(String.valueOf(name.getId())).set(name)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    loadListView();
                                                    Toast.makeText(MainActivity.this, "Pass", Toast.LENGTH_SHORT).show();
                                                }else{
                                                    Toast.makeText(MainActivity.this, "Failure! please check internet connection!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        });

                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        //Toast.makeText(SignUpActivity.this, "Successfully Upload Im!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSelectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");//image bitmap file
            Bitmap resizeBitmap = Bitmap.createScaledBitmap(bitmap,680,500,false);
            imgName.setImageBitmap(resizeBitmap);
        }
        else if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                //ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap resizeBitmap = Bitmap.createScaledBitmap(bitmap,680,500,false);
                imgName.setImageBitmap(resizeBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void loadListView(){
        ArrayList<Name> listName = new ArrayList<>();
        db.collection("names").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d: list) {
                                Name name = d.toObject(Name.class);
                                listName.add(name);
                            }
                            AdapterName adapterName = new AdapterName(MainActivity.this, R.layout.item_name, listName);
                            lvName.setAdapter(adapterName);
                        }
                    }
                });
    }
}