package com.vssnake.baturamobiletest.data.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * This is the interface of implementation of pokeapi Rest Service
 * Email : unai.correa@gmail.com
 */

public interface PokedexService {

    @GET("pokedex/1/")
    Call<PokedexDTO> getNationalPokedex();

    @GET("pokemon/{id}")
    Call<PokemonDTO> getPokemon(@Path("id") String idPokemon);
}
