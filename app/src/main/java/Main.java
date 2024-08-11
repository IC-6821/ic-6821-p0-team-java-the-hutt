import com.modules.logic.Game;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.readMove("arriba", "izquierda", 'X');
        game.readMove("medio", "centro", 'O');
        game.readMove("abajo", "derecha", 'X');

        game.displayBoard();
    }
}
