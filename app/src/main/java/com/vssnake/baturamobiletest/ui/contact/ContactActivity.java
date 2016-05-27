package com.vssnake.baturamobiletest.ui.contact;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vssnake.baturamobiletest.data.pokedex.PokedexDTO;
import com.vssnake.baturamobiletest.data.pokedex.PokedexRetrofit;
import com.vssnake.baturamobiletest.ui.BaseActivity;
import com.vssnake.baturamobiletest.R;
import com.vssnake.baturamobiletest.ui.BaseDrawerActivity;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */

public class ContactActivity extends BaseDrawerActivity<ContactPresenter> implements ContactView {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.activity_contact);
        Button button = (Button) findViewById(R.id.contact_main_button_map);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMapClicked();
            }
        });
        setPresenter(new ContactPresenter(this));
    }

    @Override
    protected int getView() {
        return R.layout.conctact_activity;
    }

    public void showMapClicked(){
        if (getPresenter() != null){
            getPresenter().onMapClicked();
        }

    }


    @Override
    public void showMap() {

        String latitude = getString(R.string.contact_address_geo_point_lat);
        String longitude = getString(R.string.contact_address_geo_point_lng);
        String pointName = getString(R.string.contact_address_geo_point_name);
        if (getNavigationManager() != null){
            getNavigationManager().launchMap(latitude,longitude,pointName);
        }
    }
}
