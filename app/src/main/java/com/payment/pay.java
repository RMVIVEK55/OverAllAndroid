package com.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.delete.fulleventbus.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class pay extends AppCompatActivity {
    EditText expiry_date; int i, s;int Cyearl;    boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
   expiry_date =findViewById(R.id.pay);
        DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
        Cyearl = Integer.parseInt(df.format(Calendar.getInstance().getTime()));
        expiry_date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                expiry_date.removeTextChangedListener(this);

                if (editable.length() == 1) {
                    int i = editable.charAt(0);
                    if (editable.charAt(0) == '/') {
                        expiry_date.setText("");
                        expiry_date.addTextChangedListener(this);
                    } else if (i > 49 && i <= 57) {
                        expiry_date.setText("0" + editable + "/");
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    } else {
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    }
                } else if (editable.length() == 2) {
                    i = editable.charAt(0);
                    s = editable.charAt(1);
                    // if (editable.toString().equalsIgnoreCase("11")||editable.toString().equalsIgnoreCase("12")) {
                    if ((i == 49) && (s == 49 || s == 50 || s == 48) && !b) {
                        expiry_date.setText(editable + "/");
                        b = true;
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    } else if ((i == 48) && (s > 48 && s <= 57) && !b) {
                        b = true;
                        expiry_date.setText(editable + "/");
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    } else {
                        b = false;
                        expiry_date.setText((char) i + ""+(char) s);
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    }

                } else if (editable.length() == 4) {
                    i = editable.charAt(0);
                    s = editable.charAt(1);
                    if (editable.charAt(3) == 48) {
                        expiry_date.setText((char) i + "" + (char) s + "/");
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    } else {
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    }
                } else if (editable.length() == 5) {
                    int t = editable.charAt(3);
                    int f = editable.charAt(4);
                    i = editable.charAt(0);
                    s = editable.charAt(1);
                    String str = (char) t + "" + (char) f;
                    int year = Integer.parseInt(str);

                    if (Cyearl >year) {
                        expiry_date.setText((char) i + "" + (char) s + "/" + (char) t);
                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    } else {

                        expiry_date.setSelection(expiry_date.getText().length());
                        expiry_date.addTextChangedListener(this);
                    }

                } else {
                    expiry_date.setSelection(expiry_date.getText().length());
                    expiry_date.addTextChangedListener(this);
                }
            }
        });
    }
}
