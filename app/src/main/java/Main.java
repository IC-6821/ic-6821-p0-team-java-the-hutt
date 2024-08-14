import com.modules.logic.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            //Player move
            // game.displayBoard(); stopped showing the board twice in each iteration.
            game.playerMove();
            if (game.verifyWin('X')) { //Checks if the player has won.
                game.displayBoard();
                System.out.println("Ganaste :D");
                break;
            }

            //AI move
            game.aiMove();
            game.displayBoard(); // moved the process of showing the board after the play to represent the most recent state of the game.
            if (game.verifyWin('O')) { //Checks if the AI has won.
                game.displayBoard();
                System.out.println("Perdiste D:");
                break;
            }
        }
    }
}
