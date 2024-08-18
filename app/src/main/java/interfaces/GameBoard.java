package interfaces;


public interface GameBoard {
     
    void setCell(int yCoordinate, int xCoordinate, char symbol);

    
    boolean canPlace(int yCoordinate, int xCoordinate);


    char getBoardSymbol(int yCoordinate, int xCoordinate);

  
    boolean verifyWin(char symbol); 


    boolean checkForTie();

}
