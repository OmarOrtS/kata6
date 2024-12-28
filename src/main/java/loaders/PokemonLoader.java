package loaders;

import model.Pokemon;

import java.io.IOException;
import java.util.Map;

public interface PokemonLoader {
    Map<Integer, Pokemon> load() throws IOException;
}
