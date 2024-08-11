import com.modules.logic.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            // Llamar al método para que haga un movimiento
            game.playerMove();
            // Mostrar tablero
            game.displayBoard();
            // llamar a funcion para verificar si gano
            if (game.verifiyWin('X')) {
                System.out.println("Has ganado");
                System.out.println("   _____  ");
                System.out.println("  |     | ");
                System.out.println("  | ^ ^ | ");
                System.out.println("  |  ‿  | ");
                System.out.println("  |_____| ");
                break;
            }
        }
    }
}
