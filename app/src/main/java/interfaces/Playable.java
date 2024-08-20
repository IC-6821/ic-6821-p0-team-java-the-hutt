package interfaces;

import org.classes.Token;

public interface Playable {

    boolean placeIfValidMove(int row, int column, Token currentPlayerToken);

    void aiMove();

    void start();

}
