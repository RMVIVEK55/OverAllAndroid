package com.background;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BindService extends Service {
    LocalBindSErvice localBindSErvice = new LocalBindSErvice();
    Random random = new Random();

    class LocalBindSErvice extends Binder {

        BindService getData() {
            return BindService.this;
        }


    }

    public int getRam() {
        return random.nextInt(100);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBindSErvice;
    }


}
