package com.example.webview;

import java.util.ArrayList;

public class NewsData {
    private static String[] newsName = {
        "berita1",
    "berita2"

    };

    private  static String [] newsDetail = {
            "iki ngono contohhhh"
    };

    private static int[] newsImage = {
            R.drawable.masdanis,
            R.drawable.simplepas

    };

    static ArrayList<News> getListData(){
        ArrayList<News> list = new ArrayList<>();
        for (int position = 0; position<newsName.length; position++) {
            News news = new News();
            news.setName(newsName[position]);
            news.setDetail(newsDetail[position]);
            news.setPhoto(newsImage[position]);
            list.add(news);

        }
        return list;
    }
}
