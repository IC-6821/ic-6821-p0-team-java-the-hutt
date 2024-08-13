import com.modules.logic.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            //Player move
            game.playerMove();
            System.out.println();
            System.out.println("-------------------");
            System.out.println("Jugador ha movido");
            System.out.println("-------------------");
            System.out.println();
            game.displayBoard(); //Display the board
            //Checks if the player won
            if (game.verifiyWin('X')) {
                System.out.println("Has ganado!!");
                System.out.println("   _____  ");
                System.out.println("  |     | ");
                System.out.println("  | ^ ^ | ");
                System.out.println("  |  ‿  | ");
                System.out.println("  |_____| ");
                break;
            }
            //Computer move
            game.aiMove();
            System.out.println();
            System.out.println("-------------------");
            System.out.println("IA ha movido");
            System.out.println("-------------------");
            System.out.println();
            game.displayBoard();
            //Checks if the computer won
            if (game.verifiyWin('O')) {
                System.out.println("Has perdido!!");
                System.out.println("   _____  ");
                System.out.println("  |     | ");
                System.out.println("  | X X | ");
                System.out.println("  | --- | ");
                System.out.println("  |_____| ");
                break;
            }
        }
    }
}
