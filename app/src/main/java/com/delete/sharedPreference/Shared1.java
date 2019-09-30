package com.delete.sharedPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.delete.fulleventbus.Fragment_onw;
import com.delete.fulleventbus.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Shared1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared1);
        final TextView txt=findViewById(R.id.txt_sh1);
        Set<String> set = new HashSet<String>();

        set.add("test 1");
        set.add("test 3");
        set.add("test 6");
        Set<String> setx = new HashSet<String>();

        set.add("test 1x");
        set.add("test 3x");
        set.add("test 6x");
     SharedPreferences sp= getSharedPreferences("txt",Context.MODE_PRIVATE);//getSha(Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();

//ed.putStringSet("v",set);
             ed.putString("txt","AppCompatActivity");
      boolean b=  ed.commit();
        Log.e("bbbbbbbbb",b+"");
//        SharedPreferences sp1= getSharedPreferences("txt",Context.MODE_PRIVATE);//getSha(Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed1=sp.edit();
//
//        ed1.putStringSet("v",set);
//       ed1.remove("v");
//        ed1.putString("txt","AppCompatActivity");
//       ed1.apply();
//        Log.e("bbbbb",sp1.getStringSet("v",setx)+"");
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frm, new Fragment_onw())
//                        .commit();
startActivity(new Intent(Shared1.this,Shared2.class));
           // txt.setText(sp.getString("txt","h"));

            }
        });

    }
}
