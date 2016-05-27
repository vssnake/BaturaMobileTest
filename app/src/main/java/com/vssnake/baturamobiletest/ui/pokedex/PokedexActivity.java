package com.vssnake.baturamobiletest.ui.pokedex;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.vssnake.baturamobiletest.R;

import com.vssnake.baturamobiletest.model.Pokemon;
import com.vssnake.baturamobiletest.ui.BaseDrawerActivity;

import butterknife.BindView;
import io.realm.RealmResults;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public class PokedexActivity extends BaseDrawerActivity<PokedexPresenter> implements PokedexView,PokedexAdapter.PokemonClicked {

    PokedexAdapter pokedexAdapter;

    @BindView(R.id.pokedex_main_rv)
    RecyclerView pokedexRV;

    @Override
    protected int getView() {
        return R.layout.pokedex_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        getSupportActionBar().setTitle(R.string.activity_pokedex);
        pokedexRV = (RecyclerView) findViewById(R.id.pokedex_main_rv);
        pokedexAdapter = new PokedexAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        pokedexRV.setLayoutManager(linearLayoutManager);
        pokedexRV.setAdapter(pokedexAdapter);


        setPresenter(new PokedexPresenter(this));

    }

    @Override
    public void setPokedexData(RealmResults<Pokemon> result) {
        pokedexAdapter.setPokemonRealmList(result);
        pokedexAdapter.notifyDataSetChanged();
    }

    @Override
    public void navigateToPokemon(Long id) {
        navigationManager.launchPokemon(id);
    }


    @Override
    public void onPokemonSelected(long pokemonID) {
        getPresenter().onPokemonClicked(pokemonID);
    }
}
