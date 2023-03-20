package com.example.numad23sp_huiyingchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView latitude, longitude, traveledDistance;
    Button reset;

    Location originalLocation;

    private final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        traveledDistance = findViewById(R.id.traveled_distance);
        reset = findViewById(R.id.reset);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getLastLocation();
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalLocation = null;
                traveledDistance.setText("Traveled distance: ");
            }
        });

    }

    private void getLastLocation(){
        System.out.println("enter into getLastLocation");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location currentLocation) {
                            System.out.println("enter into onSuccess");
                            if (currentLocation != null){
                                System.out.println("enter into if location != null");

                                if(originalLocation == null) {
                                    System.out.println("Set original location");
                                    originalLocation = currentLocation;
                                } else {
                                    double distance = originalLocation.distanceTo(currentLocation);
                                    traveledDistance.setText("Traveled distance: " + distance);
                                }

                                latitude.setText("Latitude: "+ currentLocation.getLatitude());
                                longitude.setText("Longitude: "+ currentLocation.getLongitude());
                            }
                        }
                    });
        }else {
            askPermission();
        }
    }


    private void askPermission() {
        ActivityCompat.requestPermissions(LocationActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        if (requestCode == REQUEST_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }else {
                Toast.makeText(LocationActivity.this,"Please provide the required permission",Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}