package com.vssnake.baturamobiletest.ui.pokedex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vssnake.baturamobiletest.R;
import com.vssnake.baturamobiletest.model.Pokemon;

import io.realm.RealmResults;

/**
 * Created by Unai Correa on 2016 @vssnake.
 * The adapter take the role of populate the recycleView of pokedexActivity
 * Email : unai.correa@gmail.com
 */
public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>{

    RealmResults<Pokemon> pokemonRealmList;

    PokemonClicked pokemonClicked;

    public PokedexAdapter(PokemonClicked pokemonClicked){
        this.pokemonClicked = pokemonClicked;
    }

    public void setPokemonRealmList(RealmResults<Pokemon> pokemonRealmList){
        this.pokemonRealmList = pokemonRealmList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokedex_view_holder, parent, false);

        PokemonViewHolder vh = new PokemonViewHolder(v,pokemonClicked);
        return vh;

    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.renderPokemon(pokemonRealmList.get(position));
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (pokemonRealmList != null){
            size = pokemonRealmList.size();
        }
        return size;
    }


    public static class PokemonViewHolder extends RecyclerView.ViewHolder{

        private TextView numberPokemon;
        private TextView namePokemon;
        private LinearLayout mainContainer;

        private PokemonClicked pokemonCallback;
        private Pokemon pokemon;

        public PokemonViewHolder(View v, final PokemonClicked pokemonClicked) {
            super(v);
            numberPokemon = (TextView) v.findViewById(R.id.pokedex_view_holder_number_pokemon);
            namePokemon = (TextView) v.findViewById(R.id.podedex_view_holder_name_pokemon);
            mainContainer = (LinearLayout) v.findViewById(R.id.pokedex_view_holder_container);

            this.pokemonCallback = pokemonClicked;

            mainContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pokemonCallback != null){
                        pokemonCallback.onPokemonSelected(pokemon.getPokemonID());
                    }
                }
            });

        }

        public void renderPokemon(Pokemon pokemon){
            this.pokemon = pokemon;
            namePokemon.setText(pokemon.getName());
            numberPokemon.setText(pokemon.getPokemonID()+"");
        }


    }

    public interface PokemonClicked {
        public void onPokemonSelected(long pokemonID);
    }

}
