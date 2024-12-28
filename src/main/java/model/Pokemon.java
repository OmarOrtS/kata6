package model;

public record Pokemon(String Name, int PokedexID, String type) {
    @Override
    public String toString() {
        return "Name='" + Name + '\'' +
                ", PokedexID=" + PokedexID +
                ", type='" + type + '\'';
    }
}
