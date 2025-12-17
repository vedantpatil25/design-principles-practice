package org.example.TicTacToe.states;

import org.example.TicTacToe.GameContext;
import org.example.TicTacToe.entity.Position;

public class PlayerXWonState implements GameState {
    @Override
    public void next(GameContext gameContext, Position position) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
