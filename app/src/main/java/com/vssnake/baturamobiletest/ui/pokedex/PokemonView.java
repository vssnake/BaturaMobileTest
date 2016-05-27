package com.vssnake.baturamobiletest.ui.pokedex;

import com.vssnake.baturamobiletest.ui.BaseView;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public interface PokemonView extends BaseView {

    void renderName(String name);

    void renderPokemonImg(String url);

    void renderType1(String type1);

    void renderType2(String type2);
}
