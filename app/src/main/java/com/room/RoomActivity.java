package com.room;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.delete.fulleventbus.R;
import com.delete.sqlite.SingleToneDB;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
Button save,selall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        save=findViewById(R.id.save);
        selall=findViewById(R.id.selall);
        selall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertVal();

        }
        });

    }

    private void insertVal() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        Intent d=new Intent(RoomActivity.this,ser.class);
        startService(d);


    }
}
