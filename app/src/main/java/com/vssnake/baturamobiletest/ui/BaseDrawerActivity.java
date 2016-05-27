package com.vssnake.baturamobiletest.ui;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vssnake.baturamobiletest.R;
import com.vssnake.baturamobiletest.ui.contact.ContactActivity;
import com.vssnake.baturamobiletest.ui.pokedex.PokedexActivity;

public abstract class BaseDrawerActivity<T extends BasePresenter> extends BaseActivity<T>
        implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, 0, 0);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            navigationManager.lauchContact();
            // Handle the camera action
        } else if (id == R.id.nav_pokedex) {
            navigationManager.launchPokedex();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    protected void onStart(){
        super.onStart();
        if (getPresenter() != null){
            checkedMenu(navigationView);
        }
    }

    protected void checkedMenu(NavigationView navigationView){
        MenuItem menuItem = null;
        if (ContactActivity.class.isInstance(this)){
            menuItem = navigationView.getMenu().findItem(R.id.nav_account);
        }else if(PokedexActivity.class.isInstance(this)){
            menuItem = navigationView.getMenu().findItem(R.id.nav_pokedex);
        }

        if (menuItem != null){
            menuItem.setChecked(true);
        }
    }
}
