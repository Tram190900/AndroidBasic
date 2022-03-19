package com.example.ongk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DonutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        ImageView imgDonut = (ImageView) findViewById(R.id.imgDonut);
        TextView tvName = (TextView) findViewById(R.id.tvNameDonut);
        TextView tvPrice = (TextView) findViewById(R.id.tvPriceDonut);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescriptionDonut);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            imgDonut.setImageResource(bundle.getInt("id",0));
            tvName.setText(bundle.getString("name"));
            tvPrice.setText(bundle.getString("price"));
            tvDescription.setText(bundle.getString("description"));
        }
    }
}