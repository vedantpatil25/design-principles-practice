package org.example.TicTacToe;

import org.example.TicTacToe.entity.Board;
import org.example.TicTacToe.entity.Player;
import org.example.TicTacToe.states.GameState;


public class GameContext {
    Player winner = null;
    GameState currentGameState;
    Player playerX, playerO;
    Board board;


    public Board getBoard() {
        return board;
    }
    public GameContext(Board board, Player playerO, Player playerX) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }


    public boolean isGameOver() {
        if (board.areAllCellsFilled()) {
            return true;
        }
        return currentGameState.isGameOver();
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
