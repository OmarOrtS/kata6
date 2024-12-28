package model;

import java.util.List;
import java.util.Map;

public class PokemonService {
    private final Map<Integer, Pokemon> pokedex;

    public PokemonService(Map<Integer, Pokemon> pokedex) {this.pokedex = pokedex;}

    public Pokemon getPokemonByID(int key) {return pokedex.get(key);}

    public List<Pokemon> getAllPokemon() { return pokedex.values().stream().toList();}
}
