package org.example.TicTacToe.stateCodes;

public enum Symbol {
    X('X'),
    O('O'),
    EMPTY(' ');

    private final char displayChar;

    Symbol(char displayChar) {
        this.displayChar = displayChar;
    }

    public char getDisplayChar() {
        return this.displayChar;
    }
}
