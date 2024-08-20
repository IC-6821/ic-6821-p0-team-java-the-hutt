package interfaces;

import org.classes.BoardPosition;
import org.classes.GameLevel;
import org.classes.UserConsoleInterpreter;

public interface UserIO {
    void showToPlayer(String message); //changed from ShowBoard to showToPlayer
    GameLevel processArguments(String[] args);
    public BoardPosition interpretPlayerMove(); // no se pasa el string aquí porque se pide dentro.

}
