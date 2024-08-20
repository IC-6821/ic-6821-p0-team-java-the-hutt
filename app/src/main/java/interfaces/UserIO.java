package interfaces;

import org.classes.BoardPosition;
import org.classes.GameLevel;

public interface UserIO {
    void showToPlayer(String message); //changed from ShowBoard to showToPlayer
    void processArguments(String[] args);
    public BoardPosition interpretPlayerMove(); // no se pasa el string aquí porque se pide dentro.
    GameLevel getChosenLevel();
}
