package com.example.applicationfundamentals;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * Created By: Prajwal Waingankar on 03-Jul-21
 * Github: prajwalmw
 * Email: prajwalwaingankar@gmail.com
 */

public class App extends Application {
    public static final String CHANNEL_ID_1 = "channel_1";
    public static final String CHANNEL_ID_2 = "channel_2";

    @Override
    public void onCreate() {
        super.onCreate();

        //Creating notification Channel...
        createNotifiChannel();
    }

    private void createNotifiChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //Step 1...
            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            //Step 2...
            NotificationChannel notificationChannel_1 = new NotificationChannel(
                    CHANNEL_ID_1, "Channel 1", NotificationManager.IMPORTANCE_HIGH);

            /*NotificationChannel notificationChannel_2 = new NotificationChannel(
                    CHANNEL_ID_2, "Channel 2", NotificationManager.IMPORTANCE_HIGH);*/

            notificationManager.createNotificationChannel(notificationChannel_1);
           // notificationManager.createNotificationChannel(notificationChannel_2);
            //notification channel is created...
        }
    }


}
