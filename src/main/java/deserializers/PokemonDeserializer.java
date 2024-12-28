package deserializers;

import model.Pokemon;

public interface PokemonDeserializer {
    Pokemon deserialize(String line);
}
