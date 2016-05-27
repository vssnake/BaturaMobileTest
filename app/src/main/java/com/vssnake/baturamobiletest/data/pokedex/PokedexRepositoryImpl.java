package com.vssnake.baturamobiletest.data.pokedex;

import com.vssnake.baturamobiletest.Callback;
import com.vssnake.baturamobiletest.model.Pokemon;
import com.vssnake.baturamobiletest.model.PokemonMapper;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * This take the roles of communication between the presenter and the restImplementation
 * of PokedexApi (Not the best implementation but i have not time)
 * Email : unai.correa@gmail.com
 */

public class PokedexRepositoryImpl implements PokedexRepository {

    PokedexRetrofit pokedexRetrofit;
    PokedexService pokedexService;
    Realm realm;

    public PokedexRepositoryImpl(){
        //This is not the best implementation
        pokedexRetrofit = new PokedexRetrofit();
        pokedexService = pokedexRetrofit.getPokedexService();
        realm = Realm.getDefaultInstance();
    }

    //region GetPokedex
    @Override
    public void getPokemonList(Callback<RealmResults<Pokemon>> pokedexRetrofitCallback) {
        getPokemonListRealm(pokedexRetrofitCallback);
    }




    private void getPokemonListRealm(final Callback<RealmResults<Pokemon>> pokedexRetrofitCallback){
        realm.where(Pokemon.class).findAllAsync().addChangeListener(
                new RealmChangeListener<RealmResults<Pokemon>>() {
                    @Override
                    public void onChange(RealmResults<Pokemon> results) {
                        if (results.size() != 0){
                            //The pokemon is in persistence | returning data
                            pokedexRetrofitCallback.onCallback(results);
                        }else{
                            //the pokemon list isn´t in persistence. We invoke the rest service
                            getPokedexForRestServices(pokedexRetrofitCallback);


                        }
                    }
                });
    }

    private void getPokedexForRestServices
            (final Callback<RealmResults<Pokemon>> pokedexRetrofitCallback){
        pokedexService.getNationalPokedex().enqueue(new retrofit2.Callback<PokedexDTO>() {
            @Override
            public void onResponse(Call<PokedexDTO> call, Response<PokedexDTO> response) {
                processPokedexForRest(response.body(),pokedexRetrofitCallback);
            }

            @Override
            public void onFailure(Call<PokedexDTO> call, Throwable t) {
                pokedexRetrofitCallback.onError(t);
            }
        });
    }

    private void processPokedexForRest(PokedexDTO pokedexDTO
            , Callback<RealmResults<Pokemon>> pokedexRetrofitCallback){
        List<Pokemon> pokemonList = PokemonMapper.transform(pokedexDTO);
        savePokedex(pokemonList,pokedexRetrofitCallback);
    }
    //Save pokedex to realm
    private void savePokedex( List<Pokemon> pokemonList,
                              Callback<RealmResults<Pokemon>> pokedexRetrofitCallback){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(pokemonList);
        realm.commitTransaction();
        getPokemonListRealm(pokedexRetrofitCallback);
    }

    //endregion

    //region GetPokemon
    @Override
    public void getPokemon(int idPokemon, Callback<Pokemon> pokemonCallback) {
        getPokemonRealm(idPokemon,pokemonCallback);
    }

    private void getPokemonRealm(final int idPokemon,final Callback<Pokemon> pokemonCallback){
        realm.where(Pokemon.class)
                .equalTo("pokemonID",idPokemon)
                .equalTo("isPokemonCompleteFilled",true)
                .findAllAsync()
                .addChangeListener(
                new RealmChangeListener<RealmResults<Pokemon>>() {
                    @Override
                    public void onChange(RealmResults<Pokemon> results) {
                        if (results.size() != 0){
                            //The pokemon is in persistence | returning data
                            pokemonCallback.onCallback(results.first());
                        }else{
                            //the pokemon isn´t in persistence. We invoke the rest service
                            getPokemonFromRestServices(idPokemon,pokemonCallback);


                        }}
                });
    }


    private void getPokemonFromRestServices(final int idPokemon
            ,final Callback<Pokemon> pokemonCallback){
        pokedexService.getPokemon(idPokemon + "").enqueue(new retrofit2.Callback<PokemonDTO>() {
            @Override
            public void onResponse(Call<PokemonDTO> call, Response<PokemonDTO> response) {

                processPokemonFromRest(response.body(),pokemonCallback);
            }

            @Override
            public void onFailure(Call<PokemonDTO> call, Throwable t) {
                pokemonCallback.onError(t);
            }
        });
    }

    //This function change the model retrieved from rest api service to other.
    private void processPokemonFromRest(PokemonDTO pokemonDTO,Callback<Pokemon> pokemonCallback){
        Pokemon pokemon = PokemonMapper.transform(pokemonDTO);
        savePokemon(pokemon,pokemonCallback);
    }

    //Save pokemon into the local DB
    private void savePokemon(Pokemon pokemon,Callback<Pokemon> pokemonCallback){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(pokemon);
        realm.commitTransaction();
        getPokemonRealm(pokemon.getPokemonID().intValue(),pokemonCallback);
    }
    //endregion
}
