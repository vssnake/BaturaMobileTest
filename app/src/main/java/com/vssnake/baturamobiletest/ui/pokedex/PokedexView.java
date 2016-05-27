package com.vssnake.baturamobiletest.ui.pokedex;


import com.vssnake.baturamobiletest.model.Pokemon;
import com.vssnake.baturamobiletest.ui.BaseView;

import io.realm.RealmResults;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public interface PokedexView extends BaseView {
    void setPokedexData(RealmResults<Pokemon> result);

    void navigateToPokemon(Long id);
}
