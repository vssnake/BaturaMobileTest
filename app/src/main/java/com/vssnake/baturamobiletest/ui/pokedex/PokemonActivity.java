package com.vssnake.baturamobiletest.ui.pokedex;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestFutureTarget;
import com.vssnake.baturamobiletest.R;
import com.vssnake.baturamobiletest.ui.BaseActivity;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public class PokemonActivity extends BaseActivity<PokemonPresenter> implements  PokemonView {

    public  static final String POKEMON_ID_KEY = "pokemonID";

    TextView namePokemon;
    TextView type1Pokemon;
    TextView type2Pokemon;
    ImageView imagePokemon;

    @Override
    protected int getView() {
        return R.layout.pokemon_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //get the pokemon id and pass to presenter
        Long pokemonID = getIntent().getLongExtra(POKEMON_ID_KEY,1);
        setPresenter(new PokemonPresenter(this,pokemonID));

        getSupportActionBar().setTitle(R.string.activity_pokemon);

        namePokemon = (TextView)findViewById(R.id.pokemon_main_name_text);
        type1Pokemon = (TextView)findViewById(R.id.pokemon_main_type1_text);
        type2Pokemon = (TextView)findViewById(R.id.pokemon_main_type2_text);
        imagePokemon = (ImageView) findViewById(R.id.pokemon_main_image);

    }


    @Override
    public void renderName(String name) {
        namePokemon.setText(name);
    }

    @Override
    public void renderPokemonImg(final String url) {
        Glide.with(getApplicationContext()).load(url).into(imagePokemon);
    }

    @Override
    public void renderType1(String type1) {
        type1Pokemon.setText(type1);
    }

    @Override
    public void renderType2(String type2) {
        type2Pokemon.setText(type2);
    }
}
