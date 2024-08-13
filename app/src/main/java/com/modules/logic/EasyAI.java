package com.modules.logic;
import java.util.Random;

public class EasyAI {
    private Random random;

    public EasyAI() {
        random = new Random();
    }

    public int[] getRandomMove(Board board) {
        int[] move = new int[2];
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.canPlace(row, col));

        move[0] = row;
        move[1] = col;

        return move;
    }
}