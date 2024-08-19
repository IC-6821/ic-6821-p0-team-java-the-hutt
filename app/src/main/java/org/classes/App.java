import com.modules.logic.Game;


public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.start(args);

/*         Graphics graphics = new Graphics(null, null);
        graphics.validateArguments(args);

        Game game = new Game();

        game.showBoard();

        while (true) {
            game.playerMove();
            if (game.verifyWin('X')) { // Check if the player has won
                break;
            }

            if (game.isTied()) { // Check if the game is tied
                break;
            }

            game.aiMove();
            game.showBoard(); // Show the updated board
            if (game.verifyWin('O')) { // Check if the AI has won
                break;
            }
        }*/
    } 
}
