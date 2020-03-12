package com.example.tictactoe_mvvm.model;

import androidx.lifecycle.MutableLiveData;

public class Game {

    private static final String TAG = Game.class.getName();
    private static final int BOARD_SIZE = 3;

    private Player player1;
    private Player player2;

    private Player currentPlayer = player1;
    private Cell[][] cells;

    private MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo) {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        player1 = new Player(playerOne, "*");
        player2 = new Player(playerTwo, "0");
        currentPlayer = player1;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1? player2 : player1;
    }

    public boolean hasGameEnded() {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasSameDiagonalCells())
            return true;

        if (isBoardFull())
            return true;

        return false;
    }

    public void reset() {
        player1 = null;
        player2 = null;
        currentPlayer = null;
        cells = null;
    }

    private boolean hasThreeSameHorizontalCells() {
        for (int i = 0; i < BOARD_SIZE; i++)
            if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                return true;
        return false;
    }

    private boolean hasThreeSameVerticalCells() {
        for (int i = 0; i < BOARD_SIZE; i++)
            if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                return true;
        return false;
    }

    private boolean hasSameDiagonalCells() {
        if (areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                areEqual(cells[0][2], cells[1][1], cells[2][0]))
            return true;
        return false;
    }

    private boolean isBoardFull() {
        for (Cell[] row : cells)
            for (Cell cell : row)
                if (cell != null && !cell.isEmpty())
                    return true;
        return false;
    }

    private boolean areEqual(Cell ... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || cell.isEmpty())
                return false;

        Cell comparissionBase = cells[0];
        for (int i = 1; i < BOARD_SIZE; i++)
            if (!comparissionBase.player.value.equals(cells[i].player.value))
                return false;

        return true;
    }
}
