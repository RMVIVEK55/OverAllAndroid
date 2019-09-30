package com.launch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.delete.fulleventbus.R;

public class ActivityD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        TextView tv=findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),ActivityD.class);
         //    a.setFlags(Intent.FLAG_ACTIVITY_);
               // a.setFlags( Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(a);
            }
        });
    }
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri f=intent.getData();
        Toast.makeText(getApplicationContext(),"Act4",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"res",Toast.LENGTH_SHORT).show();

    }
}
