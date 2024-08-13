import com.modules.logic.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            //Player move
            game.displayBoard();
            game.playerMove();
            if (game.verifyWin('X')) { //Checks if the player has won.
                game.displayBoard();
                System.out.println("Has ganado!!");
                break;
            }

            //AI move
            game.displayBoard();
            game.aiMove();
            if (game.verifyWin('O')) { //Checks if the AI has won.
                game.displayBoard();
                System.out.println("Has perdido!!");
                break;
            }
        }
    }
}
