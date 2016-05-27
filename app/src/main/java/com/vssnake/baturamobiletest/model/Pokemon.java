package com.vssnake.baturamobiletest.model;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Model for Pokedex
 */

public class Pokemon extends RealmObject {

    @PrimaryKey
    private
    Long pokemonID;

    private String name;

    private String urlPokemon;

    @Index
    /*
    This variable is used because we need a mode to check when a pokemon only have basic data
     (Name and id)
     */
    private boolean isPokemonCompleteFilled;

    private String imageUrl;

    private String type1;

    private String type2;

    private Integer height;

    private Integer weight;

    public Long getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(Long pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPokemon() {
        return urlPokemon;
    }

    public void setUrlPokemon(String urlPokemon) {
        this.urlPokemon = urlPokemon;
    }

    public boolean isPokemonCompleteFilled() {
        return isPokemonCompleteFilled;
    }

    public void setPokemonCompleteFilled(boolean pokemonCompleteFilled) {
        isPokemonCompleteFilled = pokemonCompleteFilled;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
