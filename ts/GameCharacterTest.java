package ts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameCharacterTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

        GameCharacter four = new GameCharacter(90, "Sprite", new String[]{"illusion", "heal"});
        GameCharacter five = new GameCharacter(120, "Hobgoblin", new String[]{"fire bomb", "berserk"});
        GameCharacter six = new GameCharacter(150, "Fairy", new String[]{"fly", "magic"});

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"))) {
            os.writeObject(new Team(new GameCharacter[]{one, two, three}));
            System.out.println("Team 1 serialized successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream("Game.ser1"))) {
            os1.writeObject(new Team(new GameCharacter[]{four, five, six}));
            System.out.println("Team 2 serialized successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        one = null;
        two = null;
        three = null;
        four = null;
        five = null;
        six = null;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"))) {
            Team team1Restore = (Team) is.readObject();
            displayTeamInfo("Team 1", team1Restore.getCharacters());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream is1 = new ObjectInputStream(new FileInputStream("Game.ser1"))) {
            Team team2Restore = (Team) is1.readObject();
            displayTeamInfo("Team 2", team2Restore.getCharacters());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static void displayTeamInfo(String teamName, GameCharacter[] characters) {
        System.out.println("Restored " + teamName + ":");
        for (GameCharacter character : characters) {
            System.out.println("Type: " + character.getType());
            System.out.println("Health: " + character.getHealth());
            System.out.println("Weapons: " + String.join(", ", character.getWeapons()));
            System.out.println(" ");
        }
    }
}

