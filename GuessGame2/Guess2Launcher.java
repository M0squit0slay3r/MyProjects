public class Guess2Launcher {
    public static void main(String[] args) {
        GuessGame2 game = new GuessGame2();
        game.startGame();
    }
}

class GuessGame2 {
    Player1 p1;
    Player2 p2;
    int targetNumber;

    public GuessGame2() {
        targetNumber = (int) (Math.random() * 101); 
    }

    public void startGame() {
        p1 = new Player1();
        p2 = new Player2();

        boolean p1isRight = false;
        boolean p2isRight = false;

        System.out.println("I'm thinking of a number between 0 and 100... ");

        while (true) {
            System.out.println("Target number to guess is: " + targetNumber);

            int guessp1 = p1.guess();
            int guessp2 = p2.guess();

            System.out.println("Player1 guessed " + guessp1);
            System.out.println("Player2 guessed " + guessp2);

            if (guessp1 == targetNumber) {
                p1isRight = true;
            }
            if (guessp2 == targetNumber) {
                p2isRight = true;
            }

            if (p1isRight || p2isRight) {
                System.out.println("We have a winner!");
                System.out.println("Player1 got it right? " + p1isRight);
                System.out.println("Player2 got it right? " + p2isRight);
                System.out.println("Game is over.");
                break;
            } else {
                if (guessp1 < targetNumber) {
                    p1.updateRange(guessp1 + 1, p1.max);
                } else {
                    p1.updateRange(p1.min, guessp1 - 1);
                }

                if (guessp2 < targetNumber) {
                    p2.updateRange(guessp2 + 1, p2.max);
                } else {
                    p2.updateRange(p2.min, guessp2 - 1);
                }

                System.out.println("Players will try again with updated ranges.");
            }
        }
    }
}
class Player1 {
    int min = 0;
    int max = 100;

    public int guess() {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public void updateRange(int newMin, int newMax) {
        min = newMin;
        max = newMax;
    }
}

class Player2 {
    int min = 0;
    int max = 100;

    public int guess() {
        return (min + max) / 2;
    }

    public void updateRange(int newMin, int newMax) {
        min = newMin;
        max = newMax;
    }
}