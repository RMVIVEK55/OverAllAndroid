package com.delete.fulleventbus;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_onw extends Fragment {

    TextView txt;
    public Fragment_onw() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_onw, container, false);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
void getDataActivity(ModleMessage obj)
{
    txt.setText(obj.age+obj.name);
}
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       txt=view.findViewById(R.id.txt_frg1);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView f=getActivity().findViewById(R.id.txt_sh1);
                SharedPreferences s= PreferenceManager.getDefaultSharedPreferences(getActivity());//.getPreferences(Context.MODE_PRIVATE);
                txt.setText(s.getString("txt","fsdffd"));
//                ModleMessageOne f=new ModleMessageOne();
//                f.setAge(1);    EditText editText=view.findViewById(R.id.edtfrg);
//                f.setName(editText.getText().toString());
//                SingletenEventBus.getInstance().post(f);
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        SingletenEventBus.getInstance().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        SingletenEventBus.getInstance().unregister(this);

    }
}
