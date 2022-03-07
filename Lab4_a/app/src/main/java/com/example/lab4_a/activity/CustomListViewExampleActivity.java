package com.example.lab4_a.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4_a.Model.Language;
import com.example.lab4_a.R;
import com.example.lab4_a.adapter.LanguageAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewExampleActivity extends AppCompatActivity {
    private List<Language> listLanguage;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lstMain);
        listLanguage = new ArrayList<>();
        listLanguage.add(new Language(1, "Ca nấu lẩu, nấu mì","Devang"));
        listLanguage.add(new Language(2, "1KG khô gà bơ tỏi","LTD Food"));
        listLanguage.add(new Language(3, "Xe cần cẩu đa năng","Thế giới đồ chơi"));
        listLanguage.add(new Language(4, "Đồ chơi dạng mô hình","Thế giới đồ chơi"));
        listLanguage.add(new Language(5, "Lãnh đạo đơn giản","Minh Long Book"));
        listLanguage.add(new Language(6, "Hiểu lòng trẻ con","Minh Long Book"));

        LanguageAdapter adapter = new LanguageAdapter(this, R.layout.item_custom_listview, listLanguage);
        listView.setAdapter(adapter);

    }
}
