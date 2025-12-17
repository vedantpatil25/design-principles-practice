package org.example.TicTacToe.entity;

import org.example.TicTacToe.GameContext;
import org.example.TicTacToe.stateCodes.Symbol;
import org.example.TicTacToe.states.PlayerOTurnState;
import org.example.TicTacToe.states.PlayerXTurnState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Board {
    int rows;
    int cols;

    List<List<Symbol>> board = new ArrayList<>();

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        for (int i = 0; i < rows; i++) {
            board.add(new ArrayList<>(Collections.nCopies(cols, Symbol.EMPTY)));
        }

    }

    public boolean checkForWin() {
        // Check all rows
        for (int i = 0; i < rows; i++) {
            Symbol first = board.get(i).get(0);
            if (first == Symbol.EMPTY) continue;

            boolean rowWin = true;
            for (int j = 1; j < cols; j++) {
                if (board.get(i).get(j) != first) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        // Check all columns
        for (int j = 0; j < cols; j++) {
            Symbol first = board.get(0).get(j);
            if (first == Symbol.EMPTY) continue;

            boolean colWin = true;
            for (int i = 1; i < rows; i++) {
                if (board.get(i).get(j) != first) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        // Check main diagonal (only for square boards)
        if (rows == cols) {
            Symbol first = board.get(0).get(0);
            if (first != Symbol.EMPTY) {
                boolean diagWin = true;
                for (int i = 1; i < rows; i++) {
                    if (board.get(i).get(i) != first) {
                        diagWin = false;
                        break;
                    }
                }
                if (diagWin) return true;
            }

            // Check anti-diagonal
            first = board.get(0).get(cols - 1);
            if (first != Symbol.EMPTY) {
                boolean antiDiagWin = true;
                for (int i = 1; i < rows; i++) {
                    if (board.get(i).get(cols - 1 - i) != first) {
                        antiDiagWin = false;
                        break;
                    }
                }
                if (antiDiagWin) return true;
            }
        }

        return false;
    }

    public Position askForPosition(GameContext gameContext) {

        if (gameContext.getCurrentGameState() instanceof PlayerOTurnState) {
            System.out.println("Player O's, Enter the position(x, y): ");
            Scanner scanner = new Scanner(System.in);
            return new Position(scanner.nextInt(), scanner.nextInt());
        } else if (gameContext.getCurrentGameState() instanceof PlayerXTurnState) {
            System.out.println("Player X's, Enter the position(x, y): ");
            Scanner scanner = new Scanner(System.in);
            return new Position(scanner.nextInt(), scanner.nextInt());
        }
        return null;
    }

    public void printResult(Player winner) {
        if (winner != null) {
            System.out.println("Winner: Player " + winner.playerType);
        } else {
            System.out.println("Game ended in a draw!");
        }
    }

    public boolean isValidMove(Position position) {
        // Check if position is within board bounds
        if (position.x < 0 || position.x >= rows || position.y < 0 || position.y >= cols) {
            return false;
        }

        // Check if the cell is empty
        return board.get(position.x).get(position.y) == Symbol.EMPTY;
    }


    public void makeMove(Position position, GameContext gameContext) {
        // Validate the move first
        if (!isValidMove(position)) {
            System.out.println("Invalid move! Position is either out of bounds or already occupied.");
            return;
        }

        // Determine which symbol to place based on current game state
        Symbol symbol = (gameContext.getCurrentGameState() instanceof PlayerOTurnState)
                ? Symbol.O
                : Symbol.X;

        board.get(position.x).set(position.y, symbol);
    }

    public void printBoard() {
        System.out.println("\nCurrent Board:");

        // Print column numbers
        System.out.print("    ");
        for (int j = 0; j < cols; j++) {
            System.out.print(j + "   ");
        }
        System.out.println();
        System.out.println("  -------------");

        for (int i = 0; i < rows; i++) {
            System.out.print(i + " | ");  // Row number
            for (int j = 0; j < cols; j++) {
                Symbol cell = board.get(i).get(j);
                System.out.print(cell.getDisplayChar() + " | ");
            }
            System.out.println();
            System.out.println("  -------------");
        }
        System.out.println();
    }

    public boolean areAllCellsFilled() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board.get(i).get(j) == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
