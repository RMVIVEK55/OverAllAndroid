package com.background;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

import androidx.annotation.Nullable;

public class IntentService extends android.app.IntentService {
    Random random = new Random();
    public IntentService() {
        super("jj");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("service","onHandleIntent");
        int a=intent.getIntExtra("a",123);
        int b=intent.getIntExtra("b",123);
        Log.e("servcie on hand",intent.getIntExtra("a",123)+"");
        Log.e("servcie on hand",intent.getIntExtra("b",123)+"");
             for (int i = 0; i < 5; i++) {
            Log.i("servcie ", "Running service " + (i + 1)+ "/5 @ " + SystemClock.elapsedRealtime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("service","onStart");
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service","onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        Log.e("service","onDestroy");
    }
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.e("service","onStartCommand");
int a=intent.getIntExtra("a",123);
        int b=intent.getIntExtra("b",123);
        Log.e("servcie on st",intent.getIntExtra("a",123)+"");
        Log.e("servcie on st",intent.getIntExtra("b",123)+"");

        if(intent!=null)
            Log.e("service","intent not null");
        else
            Log.e("service","intent  null");


         return super.onStartCommand(intent,flags,startId);
    }
    public int getRam() {
        return random.nextInt(100);
    }
    private void voi(int g) {
        stopSelf(1);
        Log.e("service","stop sel"+g);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("service","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate(); Log.e("service","onCreate");
    }

    @Override
    public void onTrimMemory(int level) {
        Log.e("service","onTrimMemory"+level);
        super.onTrimMemory(level);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e("service","onRebind");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("service","onConfigurationChanged");
    }
}
