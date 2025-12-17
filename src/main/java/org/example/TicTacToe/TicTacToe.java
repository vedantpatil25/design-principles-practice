package org.example.TicTacToe;

import org.example.TicTacToe.entity.Board;
import org.example.TicTacToe.entity.Player;
import org.example.TicTacToe.entity.Position;
import org.example.TicTacToe.states.PlayerOTurnState;

public class TicTacToe {

    public GameContext gameContext;

    TicTacToe(int rows, int cols, Player playerO, Player playerX) {
        Board board = new Board(rows, cols);
        this.gameContext = new GameContext(board, playerO, playerX);
        gameContext.setCurrentGameState(new PlayerOTurnState());

    }

    public void play() {

        while (!gameContext.isGameOver()) {
            Position position = gameContext.getBoard().askForPosition(gameContext);
            gameContext.currentGameState.next(gameContext, position);
            gameContext.getBoard().printBoard();
        }

        gameContext.getBoard().printResult(gameContext.winner);
    }
}
