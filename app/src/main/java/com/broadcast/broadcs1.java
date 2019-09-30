package com.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class broadcs1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        if(intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED))
//        {
//            Toast.makeText(context,"Boot complete",Toast.LENGTH_SHORT).show();
//        }else
//        {
//            Toast.makeText(context," not Boot complete",Toast.LENGTH_SHORT).show();
//        }
//        if(ConnectivityManager.CONNECTIVITY_ACTION.equalsIgnoreCase(intent.getAction()))
//        {
//           boolean b=intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
//           if (b)
//               Toast.makeText(context,"NO_CONNECTIVITY",Toast.LENGTH_SHORT).show();
//               else
//                   Toast.makeText(context,"CONNECTIVITY",Toast.LENGTH_SHORT).show();
//    }
        int code=getResultCode();
        String i=   getResultData();
        Bundle resBun=getResultExtras(true);
        code++;
        i+="(2)";
        Toast.makeText(context,code+" "+i+" "+resBun.getString("abc"),Toast.LENGTH_SHORT).show();
        Log.e("event 1",code+" "+i+" "+resBun);
        resBun.putString("abd","from 2");
        i="(2)";
        abortBroadcast();
        clearAbortBroadcast();
        setResult(code,i,resBun);

//        if("com.vivek".equalsIgnoreCase(intent.getAction()))
//        {
//            Toast.makeText(context,intent.getStringExtra("action_get"),Toast.LENGTH_SHORT).show();
//        }
}}
