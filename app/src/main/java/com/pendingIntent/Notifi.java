package com.pendingIntent;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

import com.delete.fulleventbus.R;
import com.google.android.gms.common.internal.service.Common;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Notifi extends Service {
    @Override
    public int onStartCommand(Intent intents, int flags, int startId) {
        Intent notificationIntent;
        notificationIntent = new Intent(getApplicationContext(), com.background.Service.class);
        Bundle bundle = new Bundle();
        bundle.putString("notification", "yes");
        notificationIntent.putExtras(bundle);

        PendingIntent intent = PendingIntent.getService(getApplicationContext(), 0, notificationIntent, 0);
        NotificationCompat.Builder noftiCompactBuilder = new NotificationCompat.Builder(this, "ctr")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Track App")

                .setContentText("your current loction in trident")
                .setContentIntent(intent)

                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("ctr", "synchorDalkia", NotificationManager.IMPORTANCE_HIGH);
            channel.setShowBadge(true);
            manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        manager.notify(1000, noftiCompactBuilder.build());


        return super.onStartCommand(intents, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
