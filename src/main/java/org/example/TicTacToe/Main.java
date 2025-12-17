package org.example.TicTacToe;

import org.example.TicTacToe.entity.Board;
import org.example.TicTacToe.entity.Player;
import org.example.TicTacToe.stateCodes.PlayerType;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        TicTacToe ticTacToe = new TicTacToe(rows, cols, new Player(PlayerType.O), new Player(PlayerType.X));
        ticTacToe.play();
    }
}
