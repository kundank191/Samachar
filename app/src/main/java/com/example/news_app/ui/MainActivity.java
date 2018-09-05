package com.example.news_app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.news_app.R;


public class MainActivity extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_view,new ListFragment())
                .commit();
    }

    void setUpFragments(String arguments){
        NewsFragment fragment = new NewsFragment();
        switch (arguments){
            case "Top":
                break;
            case "All":
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_view,fragment)
                .commit();
    }

    @Override
    public void onInteraction(String arguments) {
        setUpFragments(arguments);
    }
}
