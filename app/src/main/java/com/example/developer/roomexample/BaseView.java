package com.example.developer.roomexample;

import android.support.annotation.StringRes;

public interface BaseView {

    void showMessage(@StringRes int messageId);

    void showError(String message);

}
