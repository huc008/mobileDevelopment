package com.example.numad23sp_huiyingchen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SearchPrimeActivity extends AppCompatActivity {

    static int i = 3;
    static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_prime);
        Button linkListButton = (Button) findViewById(R.id.button_find_primes);
        linkListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView textViewPrime = (TextView) findViewById(R.id.editTextNumber2);
                final TextView textView =  (TextView) findViewById(R.id.editTextNumber);
                flag = true;
                i = 3;
                new Thread() {
                    public void run() {
                        while (flag) {
                            try {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(!notPrime(i)) {
                                            textViewPrime.setText("Latest found Prime " + Integer.toString(i));
                                        }
                                        textView.setText(Integer.toString(i));
                                        i += 2;
                                    }
                                });
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();

            }
        });


        Button terminateButton = (Button) findViewById(R.id.button_terminate_search);
        terminateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(flag) {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            flag = false;
                            SearchPrimeActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        } else {
            SearchPrimeActivity.super.onBackPressed();
        }
    }

    private boolean notPrime(Integer number){
        System.out.println("check is Prime");
        boolean flag = false;
        for (int i = 2; i <= number / 2; ++i) {
            // condition for nonprime number
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}