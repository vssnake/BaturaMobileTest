package com.vssnake.baturamobiletest.ui.pokedex;


import android.util.Log;

import com.vssnake.baturamobiletest.Callback;
import com.vssnake.baturamobiletest.data.pokedex.PokedexRepository;
import com.vssnake.baturamobiletest.data.pokedex.PokedexRepositoryImpl;
import com.vssnake.baturamobiletest.data.pokedex.PokedexRetrofit;
import com.vssnake.baturamobiletest.model.Pokemon;
import com.vssnake.baturamobiletest.ui.BasePresenter;

import io.realm.RealmResults;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public class PokedexPresenter extends BasePresenter<PokedexView>{

    private static final String TAG = PokedexPresenter.class.getSimpleName();

    PokedexRepository pokedexRepository;



    public PokedexPresenter(PokedexView baseView) {
        super(baseView);
        pokedexRepository = new PokedexRepositoryImpl();
    }

    @Override
    public void onStart() {
        getPokemonList();
    }

    @Override
    public void onStop() {

    }

    public void onPokemonClicked(Long idPokemon){
        if (getView()!= null){
            getView().navigateToPokemon(idPokemon);
        }
    }


    private void getPokemonList(){
        if (getView() != null){
            getView().startLoadingAnimation();
        }
        pokedexRepository.getPokemonList(new Callback<RealmResults<Pokemon>>() {
            @Override
            public void onCallback(RealmResults<Pokemon> result) {
                Log.d(TAG,"onGetPokemonList pokemonReturned " + result);
                if (getView() != null){
                    getView().setPokedexData(result);
                    getView().finishLoadingAnimation();
                }

            }

            @Override
            public void onError(Throwable throwable) {
                getView().finishLoadingAnimation();
                Log.e(TAG,"onGetPokemonList " ,throwable);
            }
        });
    }
}
