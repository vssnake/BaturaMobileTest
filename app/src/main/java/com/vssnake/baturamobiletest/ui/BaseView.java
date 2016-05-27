package com.vssnake.baturamobiletest.ui;

import android.content.Context;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public interface BaseView {

    Context getApplicationContext();

    void startLoadingAnimation();

    void finishLoadingAnimation();
}
