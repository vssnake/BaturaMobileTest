package com.vssnake.baturamobiletest.data.pokedex;

/**
 * Model for rest
 * */

public class PokedexDTO {

    public PokemonEntriesDTO[] pokemon_entries;

    public class PokemonEntriesDTO{
        public int entry_number;
        public PokemonSpeciesDTO pokemon_species;
    }

    public class PokemonSpeciesDTO{
        public String name;
        public String url;
    }
}
