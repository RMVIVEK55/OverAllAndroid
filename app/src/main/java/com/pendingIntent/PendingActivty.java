package com.pendingIntent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.background.ServiceActivity;
import com.broadcast.broadcs2;
import com.delete.fulleventbus.R;
import com.jobSchedule.JobSchedule;

import java.io.File;

public class PendingActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_activty);
        Button b = findViewById(R.id.txt_alarm);
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
        Intent i = new Intent(PendingActivty.this,Notifi.class);
                PendingIntent pi,p1;
                pi = PendingIntent.getService(PendingActivty.this, 9, i, PendingIntent.FLAG_UPDATE_CURRENT);

//                AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * 5), pi);
//                try {
//                    pi.send(222);
//                } catch (Exception e)



             CustomNotification();
            }
        });
    }

    public void CustomNotification() {
        // Using RemoteViews to bind custom layouts into Notification
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.s);

        // Set Notification Title
        String strtitle = "DSfaf";
        // Set Notification Text
        String strtext = "DSfasdfa";

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(this, ServiceActivity.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.px, pIntent);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"com.delete.fulleventbus")
                // Set Icon
                .setSmallIcon(R.drawable.icon_notif)
                // Set Ticker Message
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                // Dismiss Notification
                .setAutoCancel(true)
                // Set PendingIntent into Notification

                // Set RemoteViews into Notification
                .setContent(remoteViews)
                .setCustomBigContentView(remoteViews);



        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("com.delete.fulleventbus", "sdss", NotificationManager.IMPORTANCE_HIGH);
                   manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

        manager.notify(333, builder.build());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 2) {

        }
    }
}
