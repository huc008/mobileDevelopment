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
                Toast.makeText(getApplicationContext(), "Huiying Chen chen.huiyi@northeastern.edu", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        Button clickyButton = (Button) findViewById(R.id.clicky_button);
        clickyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityClicky();
            }
        });
    }

    public void openActivityClicky() {
        Intent intent = new Intent(this, ActivityClicky.class);
        startActivity(intent);
    }
}