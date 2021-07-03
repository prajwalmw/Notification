package com.example.applicationfundamentals;

import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/**
 * Created By: Prajwal Waingankar on 03-Jul-21
 * Github: prajwalmw
 * Email: prajwalwaingankar@gmail.com
 */

public class Notification {

    public void showNotification(Context context, String title, String body, String channel_id) {

        //Step 3...
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        //Step 4...
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context, channel_id)
                //If the version is > Oreo than channel_id value will be ignored as the argument...
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body);

        //If u pass a constant notification id eg. 1 than every notifi that will come will override its previous
        //notifi which means everytime only one notifi will be shown...But if you want that when u click on the button
        //u get new notification cards in status bar, u use random integer value function...

        notificationManagerCompat.notify(1, nBuilder.build());


    }
}
