package com.delete.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.delete.fulleventbus.R;

public class sqliteViewActivity extends AppCompatActivity {
    Database sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout f = new LinearLayout(this);
        f.setOrientation(LinearLayout.VERTICAL);
        Button b = new Button(this);
        b.setText("Fefargfaergrgaeg");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sql = SingleToneDB.getInstance(sqliteViewActivity.this);
                insert();

          // sql.updateCartQuantity(1);
                String str = sql.getData();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
        Button bz = new Button(this);
        bz.setText("update");

        bz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sql = SingleToneDB.getInstance(sqliteViewActivity.this);


                sql.updateCartQuantity(1);

            }
        });
        Button bx = new Button(this);
        bx.setText("update");

        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sql = SingleToneDB.getInstance(sqliteViewActivity.this);


                sql.del();

            }
        });
        f.addView(b);
        f.addView(bz);
        f.addView(bx);
        setContentView(f);

    }



    private void insert() {
        long l;
        l = sql.getInsert(1, "aruna", 1000);
        Log.e("tableeee", l + "");
        sql.getInsert(2, "vivekkkkk", 200);
        Log.e("tableeee", l + "");
    }


}
