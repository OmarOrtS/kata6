package deserializers;

import model.Pokemon;

public class TsvPokemonDeserializer implements PokemonDeserializer{
    @Override
    public Pokemon deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Pokemon deserialize(String[] fields) {
        return new Pokemon(fields[0], toInt(fields[1]), fields[2]);
    }

    private int toInt(String field) {
        return Integer.parseInt(field);
    }
}
