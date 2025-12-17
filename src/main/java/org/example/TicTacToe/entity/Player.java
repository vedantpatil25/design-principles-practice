package org.example.TicTacToe.entity;

import org.example.TicTacToe.stateCodes.PlayerType;

public class Player {
    public PlayerType playerType;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }
}
