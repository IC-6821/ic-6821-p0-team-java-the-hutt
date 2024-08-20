package org.classes;

public enum Token {
    X('X'),
    O('O');

    private final char symbol;

    Token(final char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
