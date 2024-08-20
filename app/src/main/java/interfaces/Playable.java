package interfaces;

public interface Playable {

    boolean placeIfValidMove(String yPosition, String xPosition, char symbol);

    
    boolean checkChosenPosition(String yPosition, String xPosition);


    boolean verifyWin(char playingSymbol);


    void displayBoard();


    void playerMove();


    void aiMove();


    boolean isTied();


}
