package com.vssnake.baturamobiletest.ui;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */

public abstract class BasePresenter<T extends BaseView> {

    private WeakReference<Context> contextWeak;
    private WeakReference<T> baseViewWeak;

    public BasePresenter(T baseView){
        contextWeak = new WeakReference<>(baseView.getApplicationContext());
        baseViewWeak = new WeakReference<>(baseView);

    }

    public abstract void onStart();

    public abstract  void onStop();

    public Context getContextWeak() {
        return contextWeak.get();
    }

    public T getView() {
        return baseViewWeak.get();
    }
}
