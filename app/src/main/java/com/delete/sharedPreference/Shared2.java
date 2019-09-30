package com.delete.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.delete.fulleventbus.R;

import androidx.appcompat.app.AppCompatActivity;

public class Shared2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared1);
        TextView txt=findViewById(R.id.txt_sh1);
        SharedPreferences s= PreferenceManager.getDefaultSharedPreferences(this);//getPreferences(Context.MODE_PRIVATE);

        txt.setText(s.getString("txt","gfsgsdfgs"));
    }
}
