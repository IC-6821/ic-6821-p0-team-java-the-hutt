package interfaces;


import org.classes.Token;

public interface GameContainer {

    void setGameSlot(int yCoordinate, int xCoordinate, Token currentPlayerToken);


    boolean canPlace(int yCoordinate, int xCoordinate);


    char getGameSymbolAtSlot(int yCoordinate, int xCoordinate);


    boolean verifyWin(Token playerToken);

}
