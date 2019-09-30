package com.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.delete.fulleventbus.R;

public class BroadCastActivity extends AppCompatActivity {
broadcs b=new broadcs();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        IntentFilter i=new IntentFilter("com.vivek");

    registerReceiver(b,i);//LOL DEV NOT CORRECTLY SH
    }

    @Override
    protected void onStop() {
        super.onStop();
      //  unregisterReceiver(b);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(b);
    }

    @Override
    protected void onStart() {
        super.onStart();
      //  IntentFilter i=new IntentFilter("com.vivek");
   //     registerReceiver(b,i);//LOL DEV NOT CORRECTLY SH
//        IntentFilter i=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        registerReceiver(b,i);//LOL DEV NOT CORRECTLY SHOW
    }
}
//public class MainActivity extends AppCompatActivity {
//    TextView f;    BroadcastReceiver b;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        f=findViewById(R.id.txt);
//        f.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent("com.vivek");
//                i.putExtra("action_get","intent send to broadcast");
//                sendBroadcast(i);
//            }
//        });
//        b=new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//                f.setText(intent.getStringExtra("action_get"));
//            }
//        };
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        unregisterReceiver(b);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        IntentFilter i=new IntentFilter("com.vivek");
//        registerReceiver(b,i);
//    }
//}
