package com.vssnake.baturamobiletest;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * A basic interface for manage async implementations in the app
 * Email : unai.correa@gmail.com
 */
public interface Callback<T> {

    public void onCallback(T result);

    public void onError(Throwable throwable);
}
