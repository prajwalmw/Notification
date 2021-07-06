package com.example.applicationfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
Notification notification;
ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imagebutton);
        notification = new Notification();
    }

    public void getNotification(View view) {
        notification.showNotification(MainActivity.this, "Title", "This is the body", App.CHANNEL_ID_1);
    }

    public void StartService(View view) {

        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra("name", "This is Foreground Service | It wont cancel");

        ContextCompat.startForegroundService(MainActivity.this, intent);
        //With startForegroundService the app will have only 5 seconds to move to Foreground else it will be killed.
        //Likewise, with startservice the app will have only 1 minutes to move to Foreground else it will be killed.
    }

    public void StopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
        //This will stop the service...
    }
}