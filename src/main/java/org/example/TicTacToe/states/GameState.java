package org.example.TicTacToe.states;

import org.example.TicTacToe.GameContext;
import org.example.TicTacToe.entity.Position;

public interface GameState {

    void next(GameContext context, Position position);

    boolean isGameOver();
}
