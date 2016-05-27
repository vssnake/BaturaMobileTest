package com.vssnake.baturamobiletest.model;

import com.vssnake.baturamobiletest.data.pokedex.PokedexDTO;
import com.vssnake.baturamobiletest.data.pokedex.PokemonDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * This class is made for mapper data from DTO to application Model
 * Email : unai.correa@gmail.com
 */

public class PokemonMapper {
    public static List<Pokemon> transform (PokedexDTO pokedexDTO){
        List<Pokemon> pokemons = new ArrayList<>();

        for (int count = 0;pokedexDTO.pokemon_entries.length> count ; count++){
            Pokemon pokemon = new Pokemon();
            pokemon.setPokemonID((long) pokedexDTO.pokemon_entries[count].entry_number);
            pokemon.setName(pokedexDTO.pokemon_entries[count].pokemon_species.name);
            pokemon.setUrlPokemon(pokedexDTO.pokemon_entries[count].pokemon_species.url);
            pokemon.setPokemonCompleteFilled(false);
            pokemons.add(pokemon);
        }

        return pokemons;
    }

    public static Pokemon transform (PokemonDTO pokemonDTO){
        Pokemon pokemon = new Pokemon();

        pokemon.setPokemonID((long)pokemonDTO.id);
        pokemon.setName(pokemonDTO.name);
        pokemon.setHeight(pokemonDTO.height);
        pokemon.setWeight(pokemonDTO.weight);
        pokemon.setImageUrl(pokemonDTO.sprites.front_default);

        if (pokemonDTO.types.length > 0){
            pokemon.setType1(pokemonDTO.types[0].type.name);
        }
        if (pokemonDTO.types.length > 1){
            pokemon.setType2(pokemonDTO.types[1].type.name);
        }

        pokemon.setPokemonCompleteFilled(true);

        return pokemon;
    }
}
