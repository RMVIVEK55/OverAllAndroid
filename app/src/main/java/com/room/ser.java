package com.room;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ser extends IntentService {

    public ser() {
        super("my");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {

            final    Entity e=new Entity();
            //background thread or not

                e.setStrName("ram");
                e.setValues(10);
                Long f= SingletenDB.getDb(getApplication()).dao().InsertRec(e);
                Log.d("yyyyy",f+" insert");
                List<Entity> r=SingletenDB.getDb(getApplication()).dao().selAll();

         for (int i=0;i<r.size();i++)
         {
             Log.e("ryyyy",r.get(i).id+"");
         }

            }
        }).start();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
    }
}
