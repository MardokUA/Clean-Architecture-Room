package com.example.developer.roomexample.application;

import android.app.Application;
import android.content.Context;
import android.os.Build;

public class RoomExample extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    //Test implementation until Dagger2 doesn't implements
    public static Context getContext() {
        return sContext;
    }

    public static boolean isKitkat() {
        return Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT;
    }
}
