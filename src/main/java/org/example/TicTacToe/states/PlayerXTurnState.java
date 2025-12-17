package org.example.TicTacToe.states;

import org.example.TicTacToe.GameContext;
import org.example.TicTacToe.entity.Player;
import org.example.TicTacToe.entity.Position;
import org.example.TicTacToe.stateCodes.PlayerType;

public class PlayerXTurnState implements GameState {
    @Override
    public void next(GameContext gameContext, Position position) {
        if (gameContext.getBoard().isValidMove(position)) {
            gameContext.getBoard().makeMove(position, gameContext);
            if (gameContext.getBoard().checkForWin()) {
                gameContext.setCurrentGameState(new PlayerOWonState());
                gameContext.setWinner(new Player(PlayerType.X));
                return;
            }
        } else {
            System.out.println("Invalid move. Try again.");
            return;
        }

        gameContext.setCurrentGameState(new PlayerOTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
