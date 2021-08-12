package com.example.applicationfundamentals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

/**
 * Created By: Prajwal Waingankar on 12-Aug-21
 * Github: prajwalmw
 * Email: prajwalwaingankar@gmail.com
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if(Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0)
                new Notification().showNotification(context, "Airplane Mode", "Airplane mode ON", App.CHANNEL_ID_1);
            else
                NotificationManagerCompat.from(context).cancel(1);
        }
        else {
            if(Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0)
                new Notification().showNotification(context, "Airplane Mode", "Airplane mode ON", App.CHANNEL_ID_1);
            else
                NotificationManagerCompat.from(context).cancel(1);
        }

    }
}
