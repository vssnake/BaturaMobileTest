package com.vssnake.baturamobiletest.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.vssnake.baturamobiletest.ui.contact.ContactActivity;
import com.vssnake.baturamobiletest.ui.pokedex.PokedexActivity;
import com.vssnake.baturamobiletest.ui.pokedex.PokemonActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Manage the navigation between windows
 * Email : unai.correa@gmail.com
 */
public class NavigationManager {

    WeakReference<Activity> activityWeak;

    public NavigationManager(Activity activity){
        activityWeak = new WeakReference<>(activity);

    }

    public void launchMap(String latitude,String longitude,String pointName){
        if (activityWeak.get() != null){
            Uri gmmIntentUri = Uri.parse("geo:" +latitude +"," + longitude +
                   "?q=<"+latitude+">,<"+longitude+">("+pointName+")");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(activityWeak.get().getPackageManager()) != null) {
                activityWeak.get().startActivity(mapIntent);
            }
        }
    }

    public void lauchContact(){
        if (activityWeak.get() != null){
            Intent intent = new Intent(activityWeak.get(),ContactActivity.class);
            activityWeak.get().startActivity(intent);
        }
    }

    public void launchPokedex() {
        if (activityWeak.get() != null){
            Intent intent = new Intent(activityWeak.get(),PokedexActivity.class);
            activityWeak.get().startActivity(intent);
        }
    }

    public void launchPokemon(Long id){
        if (activityWeak.get() != null){
            Intent intent = new Intent(activityWeak.get(), PokemonActivity.class);
            intent.putExtra(PokemonActivity.POKEMON_ID_KEY,id);
            activityWeak.get().startActivity(intent);
        }
    }
}
