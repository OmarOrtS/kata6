package API;

import com.google.gson.Gson;
import model.Pokemon;
import model.PokemonService;
import spark.Spark;

public class SparkPokemonController {
    private final Gson gson = new Gson();
    private final PokemonService pokemonService;

    public SparkPokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
        Spark.port(8080);
        getPokemonByPokedexID();
        getAllPokemonInpokedex();
    }

    private void getAllPokemonInpokedex() {
        Spark.get("/pokemon", (request, response) -> {
            response.type("application/json");
            return gson.toJson(pokemonService.getAllPokemon());
        });
    }

    private void getPokemonByPokedexID() {
        Spark.get("/pokemon/:id", ((request, response) -> {
            Pokemon pokemon = pokemonService.getPokemonByID(Integer.parseInt(request.params((":id"))));
            if (pokemon == null){
                response.status(404);
                return "Pokemon Not Found";
            }
            response.type("application/json");
            return gson.toJson(pokemon);
        }));
    }
}
