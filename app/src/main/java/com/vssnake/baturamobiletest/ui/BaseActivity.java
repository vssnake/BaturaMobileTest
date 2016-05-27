package com.vssnake.baturamobiletest.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.vssnake.baturamobiletest.R;
import com.vssnake.baturamobiletest.ui.contact.ContactActivity;
import com.vssnake.baturamobiletest.ui.pokedex.PokedexActivity;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * This class implemented the basic function of navigationView
 * Email : unai.correa@gmail.com
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T basePresenter;
    protected  NavigationManager navigationManager;
    Toolbar toolbar;

    AnimatedCircleLoadingView circleLoadingView;
    RelativeLayout circleLoadingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        circleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);
        circleLoadingContainer = (RelativeLayout) findViewById(R.id.circle_loading_container);

    }

    public void startLoadingAnimation(){
        if (circleLoadingView != null){
            circleLoadingContainer.setVisibility(View.VISIBLE);
            circleLoadingView.startIndeterminate();
        }
    }

    public void finishLoadingAnimation(){
        if (circleLoadingView != null){

            circleLoadingView.stopOk();
            circleLoadingContainer.animate().alpha(0).setDuration(2000);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }





    protected void onStart(){
        super.onStart();
        if (basePresenter != null){
            navigationManager = new NavigationManager(this);
            basePresenter.onStart();
        }
    }

    protected void onStop(){
        super.onStop();
        if (basePresenter != null){
            navigationManager = null;
            basePresenter.onStop();
        }
    }



    @LayoutRes
    protected abstract int getView();

    public T getPresenter() {
        return basePresenter;
    }

    public void setPresenter(T basePresenter) {
        this.basePresenter = basePresenter;
    }

    protected NavigationManager getNavigationManager(){
        return navigationManager;
    }
}
