package com.background;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Service extends android.app.Service {

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
        int a,b;
        a=startId;
        if(Looper.myLooper()==Looper.getMainLooper())
            Log.e("service","main t");
        else
            Log.e("service","bg t");
Log.d("service","");
new Thread(new Runnable() {
    @Override
    public void run() {
        if(Looper.myLooper()==Looper.getMainLooper())
            Log.e("service","main t");
        else
            Log.e("service","bg t");
    }
}).start();
        if(intent!=null)
            Log.e("service","intent not null");
        else
            Log.e("service","intent  null");
voi(1);

        return  START_STICKY;
    }

    private void voi(int g) {
        stopSelf(g);
        Log.e("service","stop sel"+g);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("service","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        Log.e("service","onCreate");
        super.onCreate();
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
