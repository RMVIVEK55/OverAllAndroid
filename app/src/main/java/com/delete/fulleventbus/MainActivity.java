package com.delete.fulleventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.but1);
                txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModleMessage f = new ModleMessage();
                f.setAge(100);
                EditText editText=findViewById(R.id.edtactivity);
                f.setName(editText.getText().toString());
                SingletenEventBus.getInstance().post(f);
            }
        });
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frm, new Fragment_onw())
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SingletenEventBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SingletenEventBus.getInstance().unregister(this);

    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    void getDataFromEventsd(ModleMessageOne obj) {
    txt.setText(obj.age + obj.name+333);
        Log.e("eee","33");

    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    void getDataFromEvent(ModleMessageOne obj) {
    txt.setText(obj.age + obj.name+1111);
        Log.e("eee","111");
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    void getDataFromEvents(ModleMessageOne obj) {
        txt.setText(obj.age + obj.name+222);
        Log.e("eee","22");

    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    void getDataFromEventsdd(ModleMessageOne obj) {
    txt.setText(obj.age + obj.name+244);
        Log.e("eee","444");

    }
}
