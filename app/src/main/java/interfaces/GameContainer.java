package interfaces;


import org.classes.Token;

public interface GameContainer {

    void setGameSlot(int row, int column, Token currentPlayerToken);

    boolean canPlace(int row, int column);

    boolean verifyWin(Token playerToken);

    boolean isTied();

}
