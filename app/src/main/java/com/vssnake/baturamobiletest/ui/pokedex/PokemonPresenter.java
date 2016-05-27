package com.vssnake.baturamobiletest.ui.pokedex;

import android.util.Log;

import com.vssnake.baturamobiletest.Callback;
import com.vssnake.baturamobiletest.data.pokedex.PokedexRepository;
import com.vssnake.baturamobiletest.data.pokedex.PokedexRepositoryImpl;
import com.vssnake.baturamobiletest.model.Pokemon;
import com.vssnake.baturamobiletest.ui.BasePresenter;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public class PokemonPresenter extends BasePresenter<PokemonView> {

    Long pokemonID;

    private static final String TAG = PokemonPresenter.class.getSimpleName();

    PokedexRepository pokedexRepository;

    public PokemonPresenter(PokemonView baseView,Long pokemonID) {
        super(baseView);
        this.pokemonID = pokemonID;
        pokedexRepository = new PokedexRepositoryImpl();
    }

    @Override
    public void onStart() {
        getPokemon(pokemonID);
    }

    @Override
    public void onStop() {

    }

    private void getPokemon(Long pokemonID){
        if (getView()!= null){
            getView().startLoadingAnimation();
        }
        pokedexRepository.getPokemon(pokemonID.intValue(), new Callback<Pokemon>() {
            @Override
            public void onCallback(Pokemon result) {
                if (getView() != null){
                    getView().renderName(result.getName());
                    getView().renderPokemonImg(result.getImageUrl());
                    getView().renderType1(result.getType1());
                    getView().renderType2(result.getType2());
                }
                if (getView() != null){
                    getView().finishLoadingAnimation();
                }

            }

            @Override
            public void onError(Throwable throwable) {
                getView().finishLoadingAnimation();
                Log.e(TAG,"onGetPokemon " ,throwable);
            }
        });
    }
}
