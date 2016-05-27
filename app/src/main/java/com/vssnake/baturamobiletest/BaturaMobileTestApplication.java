package com.vssnake.baturamobiletest;

import android.app.Application;

import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */

public class BaturaMobileTestApplication extends Application {


    @Override
    public void onCreate(){
        super.onCreate();
        init();

    }

    private void init(){
        //Realm initialization
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }


}
