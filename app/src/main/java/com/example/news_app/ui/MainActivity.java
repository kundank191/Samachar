package com.example.news_app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.news_app.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_view,new NewsFragment())
                .commit();
    }
}
