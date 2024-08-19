package com.modules.logic;
import java.util.Random;

public class EasyAI {
    private Random positionGenerator;

    public EasyAI() {
        positionGenerator = new Random();
    }

    public int[] getRandomMove(Board board) {
        int[] move = new int[2];
        int row = positionGenerator.nextInt(3);
        int column = positionGenerator.nextInt(3);

        while (!board.canPlace(row, column)){
            row = positionGenerator.nextInt(3);
            column = positionGenerator.nextInt(3);
        }

        move[0] = row;
        move[1] = column;

        return move;
    }

    public void makeMove() {
        // TODO: implement or discard this method
    }
}