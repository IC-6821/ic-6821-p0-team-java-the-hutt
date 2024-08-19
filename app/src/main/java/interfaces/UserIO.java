package interfaces;

import org.classes.BoardPosition;

public interface UserIO {
    void showBoard(); //TODO: chamge from showBoard to showToPlayer(String message)
    void playerMove(); //todo: delete and replace for 'interpretPlayerMove' defined below
    void validateArguments(String[] args); // TODO: en vez de ser void debe retornar algo
    public BoardPosition interpretPlayerMove(); // no se pasa el string aquí porque se pide dentro.

}
