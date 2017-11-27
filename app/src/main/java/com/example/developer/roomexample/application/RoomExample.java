package com.example.developer.roomexample.application;

import android.app.Application;
import android.os.Build;

public class RoomExample extends Application {

    public static boolean isKitkat() {
        return Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT;
    }
}
