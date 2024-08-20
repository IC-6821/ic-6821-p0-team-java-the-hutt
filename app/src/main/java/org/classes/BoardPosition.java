package org.classes;

public enum BoardPosition {
    TOP_LEFT(0, 0),
    TOP_CENTER(0, 1),
    TOP_RIGHT(0, 2),
    MIDDLE_LEFT(1, 0),
    MIDDLE_CENTER(1, 1),
    MIDDLE_RIGHT(1, 2),
    BOTTOM_LEFT(2, 0),
    BOTTOM_CENTER(2, 1),
    BOTTOM_RIGHT(2, 2);

    private final int row;
    private final int column;

    BoardPosition(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
