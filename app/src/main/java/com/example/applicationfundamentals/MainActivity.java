package com.example.applicationfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
Notification notification;
ImageButton imageButton;
BroadcastReceiver br;
IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imagebutton);
        notification = new Notification();

        br = new MyBroadcastReceiver();
        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(br, intentFilter);
    }

    public void getNotification(View view) {
        //Notification is learnt...
        notification.showNotification(this, "Title", "This is the body", App.CHANNEL_ID_1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }
}