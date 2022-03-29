package com.example.ongk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

       Donut donut = (Donut) getIntent().getSerializableExtra("selection");
        if(donut!=null){
            imgDonut.setImageResource(donut.getId());
            tvName.setText(donut.getTen());
            tvPrice.setText(donut.getGia());
            tvDescription.setText(donut.getMoTa());
        }
    }
}