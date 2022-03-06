package com.example.lab3_c

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ChonMauActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chon_mau)
        var btnMauDo = findViewById<Button>(R.id.btnDo);
        btnMauDo.setOnClickListener (View.OnClickListener {
            val img = findViewById<ImageView>(R.id.imgPhone)
            img.setImageResource(R.drawable.vs_red_a_2)
            val txtMau = findViewById<TextView>(R.id.txtMau)
            txtMau.setText("Màu: đỏ")
            val txtNCC = findViewById<TextView>(R.id.txtNCC)
            txtNCC.setText("Cung cấp bởi Tiki Tradding")
            val txtGia = findViewById<TextView>(R.id.txtGia)
            txtGia.setText("1.790.000đ")
        })

        var btnMauDen = findViewById<Button>(R.id.btnDen);
        btnMauDen.setOnClickListener (View.OnClickListener {
            val img = findViewById<ImageView>(R.id.imgPhone)
            img.setImageResource(R.drawable.vsmart_black_star_1)
            val txtMau = findViewById<TextView>(R.id.txtMau)
            txtMau.setText("Màu: đen")
            val txtNCC = findViewById<TextView>(R.id.txtNCC)
            txtNCC.setText("Cung cấp bởi Tiki Tradding")
            val txtGia = findViewById<TextView>(R.id.txtGia)
            txtGia.setText("1.790.000đ")
        })

        var btnMauXanh = findViewById<Button>(R.id.btnXanh);
        btnMauXanh.setOnClickListener (View.OnClickListener {
            val img = findViewById<ImageView>(R.id.imgPhone)
            img.setImageResource(R.drawable.vsmart_live_xanh_1)
            val txtMau = findViewById<TextView>(R.id.txtMau)
            txtMau.setText("Màu: xanh")
            val txtNCC = findViewById<TextView>(R.id.txtNCC)
            txtNCC.setText("Cung cấp bởi Tiki Tradding")
            val txtGia = findViewById<TextView>(R.id.txtGia)
            txtGia.setText("1.790.000đ")
        })

        var btnMauBac = findViewById<Button>(R.id.btnBac);
        btnMauBac.setOnClickListener (View.OnClickListener {
            val img = findViewById<ImageView>(R.id.imgPhone)
            img.setImageResource(R.drawable.vs_bac_1)
            val txtMau = findViewById<TextView>(R.id.txtMau)
            txtMau.setText("Màu: bạc")
            val txtNCC = findViewById<TextView>(R.id.txtNCC)
            txtNCC.setText("Cung cấp bởi Tiki Tradding")
            val txtGia = findViewById<TextView>(R.id.txtGia)
            txtGia.setText("1.790.000đ")
        })

        var btnXong = findViewById<Button>(R.id.btnXong)
        btnXong.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            
        })
    }
}