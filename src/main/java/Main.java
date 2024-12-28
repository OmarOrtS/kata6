import API.SparkPokemonController;
import deserializers.TsvPokemonDeserializer;
import loaders.FilePokemonLoader;
import model.Pokemon;
import model.PokemonService;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        new SparkPokemonController(new PokemonService(initializePokedex()));
    }

    private static Map<Integer, Pokemon> initializePokedex() throws IOException {
        return new FilePokemonLoader(new File(new File("KantoPokedex").getAbsolutePath()),
                new TsvPokemonDeserializer()).load();
    }
}
