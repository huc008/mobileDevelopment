package com.example.numad23sp_huiyingchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //...set what happens when the user clicks
        Button btn = (Button) findViewById(R.id.aboutme_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAboutMe();
            }
        });

        Button clickyButton = (Button) findViewById(R.id.clicky_button);
        clickyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityClicky();
            }
        });

        Button linkListButton = (Button) findViewById(R.id.link_collector);
        linkListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityLinkCollector();
            }
        });

        Button searchPrimeButton = (Button) findViewById(R.id.search_prime);
        searchPrimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySearchPrime();
            }
        });

        Button locationButton = (Button) findViewById(R.id.location);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openActivityLocation();}
        });
    }

    public void openActivityClicky() {
        Intent intent = new Intent(this, ActivityClicky.class);
        startActivity(intent);
    }

    public void openActivityAboutMe() {
        Intent intent = new Intent(this, AboutMeActivity.class);
        startActivity(intent);
    }

    public void openActivityLinkCollector() {
        Intent intent = new Intent(this, LinkListActivity.class);
        startActivity(intent);
    }

    public void openActivitySearchPrime() {
        Intent intent = new Intent(this, SearchPrimeActivity.class);
        startActivity(intent);
    }

    public void openActivityLocation() {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
}