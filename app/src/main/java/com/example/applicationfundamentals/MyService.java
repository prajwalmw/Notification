package com.example.applicationfundamentals;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

/**
 * Created By: Prajwal Waingankar on 06-Jul-21
 * Github: prajwalmw
 * Email: prajwalwaingankar@gmail.com
 */

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String message = intent.getStringExtra("name");
        Intent intent1 = new Intent(this, MainActivity.class); //This will open MainActivity.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
        //For PendingIntent we need normal intent so we created intent1 and than passing that to the pendingintent.
        /* This is because Notification is a foreign app therefore, if we pass Intent to it than it will execute but
        Notification will use its permission to execute the request. But if we are opening call activity and Notification
        doesnt has that permission in that case our app wont work....But if we use PendingIntent intent in that case
        Notification will use our application permission and not Notification class permission...
        */

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, App.CHANNEL_ID_1)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is Title")
                .setContentText(message);

        startForeground(2, builder.build());
        //notification id is very imp if you keep same throughout app than all the notification
        // throughout the app will override...
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
