package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MyAdapter adapter;

    ImageView eklik;
    ImageView masdanis;
    ImageView simplepas;

    private RecyclerView rvNews;
    private ArrayList<News> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //news
        rvNews = findViewById(R.id.rv_news);
        rvNews.setHasFixedSize(true);


        list.addAll(NewsData.getListData());
        showRecyclerList();


        //image slider
        viewPager = findViewById(R.id.viewPager);
        adapter = new MyAdapter(this);
        viewPager.setAdapter(adapter);

        //icon
        eklik = findViewById(R.id.eklik);
        masdanis = findViewById(R.id.Masdanis);
        simplepas = findViewById(R.id.simplepas);


        eklik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              gotoUrl("https://pppbulu.dkp.jatimprov.go.id/ikm/kuisioner.php");
            }
        });

        masdanis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://pppbulu.dkp.jatimprov.go.id/esurat/login/index.php");
            }
        });

        simplepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://simpelpas.pppbulu.com/");
            }
        });

    }

    private void showRecyclerList() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        ListNewsAdapter listNewsAdapter = new ListNewsAdapter(list);
        rvNews.setAdapter(listNewsAdapter);
    }

    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}