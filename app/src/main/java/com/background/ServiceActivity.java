package com.background;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.delete.fulleventbus.A1;
import com.delete.fulleventbus.R;

public class ServiceActivity extends Activity {
    Button btnService;
    A1 a1;
    boolean isBind = false;
    BindService bindService;
    BindService.LocalBindSErvice localBindSErvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btnService = findViewById(R.id.service);

        btnService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getApplicationContext(), Service.class);
                        i.putExtra("a", 5);

                        Intent i1 = new Intent(getApplicationContext(), Service.class);
                        i1.putExtra("b", 9);
                        startService(i1);
                        startService(i);
                    }
                }).start();


            }
        });
        final Button btniService = findViewById(R.id.intservice);
        btniService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), IntentService.class);
                i.putExtra("a", 5);

                Intent i1 = new Intent(getApplicationContext(), IntentService.class);
                i1.putExtra("b", 9);
                Intent i11 = new Intent(getApplicationContext(), IntentService.class);
                i11.putExtra("b", 9);
                startService(i11);
                startService(i1);
                startService(i);


            }
        });
        Button jbtniService = findViewById(R.id.jobintservice);
        jbtniService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("a", 5);
                i.putExtra("b", "omsai");

                JobIntSErvice.enqueueWork(getApplicationContext(), JobIntSErvice.class, 107, i);
                Intent i1 = new Intent();
                i1.putExtra("a", 11);
                i1.putExtra("b", "omsakthi");
                JobIntSErvice.enqueueWork(getApplicationContext(), JobIntSErvice.class, 107, i1);
                Intent i11 = new Intent();
                i11.putExtra("a", 11);
                i11.putExtra("b", "omsakthi");
                JobIntSErvice.enqueueWork(getApplicationContext(), JobIntSErvice.class, 107, i11);

            }
        });
        Button jbtniServiceget = findViewById(R.id.bindserviceget);
        jbtniServiceget.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
         Log.e("bind",bindService.getRam()+"");

            }
        });
        Button btnBindServiceSt = findViewById(R.id.bindservicest);
        btnBindServiceSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isBind) {
                    Intent i = new Intent(ServiceActivity.this, BindService.class);
                    bindService(i, connection, Context.BIND_AUTO_CREATE);//all bind daata
                    Log.e("Bind","bind");
                }
                else
                {
                    Log.e("Bind","already bind");
                }
            }
        });
        Button btnBindServiceStop = findViewById(R.id.bindservicestop);
        btnBindServiceStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (isBind) {
                    unbindService(connection);
                    isBind=false;
                    Log.e("Bind","unbind");
                }
                else
                {
                    Log.e("Bind","already un binf");
                }


            }
        });
        Button btnAIDLServiceStop = findViewById(R.id.aidlservice);
        btnAIDLServiceStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
Intent i=new Intent(ServiceActivity.this,AidlService.class);
//bindService(i,Context.BIND_AUTO_CREATE)
                try {
                    a1.getS("a");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
    }
private ServiceConnection aidlConn=new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        a1=A1.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
};
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            localBindSErvice = (BindService.LocalBindSErvice) service;
            bindService = localBindSErvice.getData();
            isBind = true;        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isBind)
            unbindService(connection);
    }
}
