package com.vssnake.baturamobiletest.data.pokedex;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */

public class PokemonDTO {
    public int id;
    public String name;
    public int weight;
    public int height;

    public SpritesDTO sprites;
    public TypesDTO[] types;



    public class SpritesDTO{
        public String front_default;
    }

    public class TypesDTO{
        public int slot;
        public TypeDTO type;
    }

    public class TypeDTO{
        public String name;
    }
}
