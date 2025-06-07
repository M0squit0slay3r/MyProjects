package ts;

import java.io.*;

class GameCharacter implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int health;
    private final String type;
    private final String[] weapons;

    public GameCharacter(int health, String type, String[] weapons) {
        this.health = health;
        this.type = type;
        this.weapons = weapons;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public String[] getWeapons() {
        return weapons;
    }
}

class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    private final GameCharacter[] characters;

    public Team(GameCharacter[] characters) {
        this.characters = characters;
    }

    public GameCharacter[] getCharacters() {
        return characters;
    }
}

