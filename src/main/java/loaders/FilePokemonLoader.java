package loaders;

import deserializers.PokemonDeserializer;
import model.Pokemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FilePokemonLoader implements PokemonLoader{
    private final File file;
    private final PokemonDeserializer deserializer;

    public FilePokemonLoader(File file, PokemonDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public HashMap<Integer, Pokemon> load() throws IOException {
        HashMap<Integer, Pokemon> pokedex = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
                pokedex.put(deserializer.deserialize(line).PokedexID(), deserializer.deserialize(line));
        }

        return pokedex;
    }
}
