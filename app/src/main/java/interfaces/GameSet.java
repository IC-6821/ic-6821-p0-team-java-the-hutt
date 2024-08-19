package interfaces;

public interface GameSet {

    boolean placeIfValidMove(String yPosition, String xPosition, char symbol);

    
    boolean checkChosenPosition(String yPosition, String xPosition);


    boolean verifyWin(char playingSymbol);


    void displayBoard();


    void playerMove();


    void aiMove();


    boolean isTied();


}
