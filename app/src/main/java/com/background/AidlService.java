package com.background;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


import com.delete.fulleventbus.A1;

import androidx.annotation.Nullable;

public class AidlService extends Service
{

A1.Stub obj=new A1.Stub() {

    @Override
    public void getS(String d) throws RemoteException {

    }


};


//    @Override
//    public boolean onUnbind(Intent intent) {
//        return super.onUnbind(intent);
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return obj;
    }
}
