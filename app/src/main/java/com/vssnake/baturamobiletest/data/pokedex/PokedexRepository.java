package com.vssnake.baturamobiletest.data.pokedex;

import android.view.ActionMode;

import com.vssnake.baturamobiletest.Callback;
import com.vssnake.baturamobiletest.model.Pokemon;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */

public interface PokedexRepository {

    void getPokemonList(Callback<RealmResults<Pokemon>> pokedexRetrofitCallback);

    void getPokemon(int idPokemon,Callback<Pokemon> pokemonRetrofitCallback);
}
