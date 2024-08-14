import com.modules.logic.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.displayBoard(); // moved from the body of the loop to the outside so it only prints it before playing on the first run
        while (true) {
            //Player move
            // game.displayBoard(); stopped showing the board twice in each iteration.
            game.playerMove();
            if (game.verifyWin('X')) { //Checks if the player has won.
                break;
            }

            if (game.isTied()) {break;} // we chose to only break since the printing instructions were delegated to the game

            //AI move
            game.aiMove();
            game.displayBoard(); // moved the process of showing the board after the play to represent the most recent state of the game.
            if (game.verifyWin('O')) { //Checks if the AI has won.
                break;
            }
        }
    }
}
