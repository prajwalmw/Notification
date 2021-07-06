package com.example.applicationfundamentals;

import androidx.appcompat.app.AppCompatActivity;

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
        //Notification is learnt...
        notification.showNotification(this, "Title", "This is the body", App.CHANNEL_ID_1);
    }
}