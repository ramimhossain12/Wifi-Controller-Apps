package com.example.wificontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Paint;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private ImageView imageView1,imageView2;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1= findViewById(R.id.imgONID);
        imageView2= findViewById(R.id.imgOFFID);
        textView= findViewById(R.id.textID);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 wifiManager = ( WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                 wifiManager.setWifiEnabled(true);
                Toast.makeText(MainActivity.this,"Wifi On",Toast.LENGTH_SHORT).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager = ( WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
                Toast.makeText(MainActivity.this,"Wifi Off",Toast.LENGTH_SHORT).show();
            }
        });

        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView.setText("WIFI Signal Check");
    }
}