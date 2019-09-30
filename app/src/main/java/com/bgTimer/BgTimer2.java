package com.bgTimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.delete.fulleventbus.R;

import org.w3c.dom.Text;

public class BgTimer2 extends AppCompatActivity {
    TextView timer; Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg_timer2);
  timer=findViewById(R.id.timer);
        intent = new Intent(BgTimer2.this, BgTimerService.class);
        startService(intent);
        registerReceiver(broadcastReceiver, new IntentFilter(BgTimerService.BROADCAST_ACTION));
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        TextView start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        TextView stop=findViewById(R.id.stop);
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unregisterReceiver(broadcastReceiver);
//                stopService(intent);
//            }
//        });
    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            updateUI(intent);
        }
    };
    private void updateUI(Intent intent) {
        int time = intent.getIntExtra("time", 0);

        Log.d("Hello", "Time " + time);

        int mins = time / 60;
        int secs = time % 60;
        int hour=mins/60;
        timer.setText(hour+"" + mins + ":"
                + String.format("%02d", secs));
    }
}
