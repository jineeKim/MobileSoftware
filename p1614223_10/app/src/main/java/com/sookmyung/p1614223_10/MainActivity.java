package com.sookmyung.p1614223_10;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    Button b_start;
    EditText et;

    double distance;
    int count = 0;
    int REQUEST_CODE_LOCATION = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        b_start = (Button) findViewById(R.id.btn_start);
        ll = (LinearLayout) findViewById(R.id.ll_distance);
        et = (EditText) findViewById(R.id.et_distance);

        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (count == 0) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_LOCATION);
            } else
                count++;
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                    1000, // 통지사이의 최소 시간간격 (miliSecond)
                    1, // 통지사이의 최소 변경거리 (m)
                    mLocationListener);

            b_start.setText("측정 종료");


        } else {
            b_start.setText("측정 시작");
            ll.setVisibility(View.VISIBLE);
            Log.d("test", "onLocationChanged, !!!!!!" + distance);

            et.setText(String.valueOf(distance));

            count = 0;
        }
    }

    double beforeLocation = 0;
    double beforeLatitude = 0;

    double currentLocation = 0;
    double currentLatitude = 0;

    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {

            if (beforeLocation == 0) {
                beforeLocation = location.getLongitude();
                beforeLatitude = location.getLatitude();
            } else {
                currentLocation = location.getLongitude();
                currentLatitude = location.getLatitude();

                distance += distanceToPoint(beforeLatitude, beforeLocation, currentLatitude, currentLocation);
                Log.d("test", "onLocationChanged, location:" + distance);

                beforeLocation = currentLocation;
                beforeLatitude = currentLatitude;
            }

        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }
    };

    private double distanceToPoint(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
