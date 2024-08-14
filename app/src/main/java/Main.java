import com.modules.logic.Game;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Argumentos incompatibles. Se esperan 2 para ejecutar el juego. \n Sugerencia: usar -n f");
            return;
        }

        if (!args[0].equals("-n")) {
            System.out.println("Parámetro desconocido, ejecuta el juego nuevamente.");
            return;
        }

        String difficulty = args[1];
        if (!difficulty.equals("f")) {
            System.out.println("Esta dificultad aún no está disponible. Utilice -n f para jugar.");
            return;
        }

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
