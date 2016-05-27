package com.vssnake.baturamobiletest.data.pokedex;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Initialization of retrofit and this services
 * Email : unai.correa@gmail.com
 */
public class PokedexRetrofit {

    private PokedexService pokedexService;

    public PokedexRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokedexService = retrofit.create(PokedexService.class);
    }


    public PokedexService getPokedexService() {
        return pokedexService;
    }

}
