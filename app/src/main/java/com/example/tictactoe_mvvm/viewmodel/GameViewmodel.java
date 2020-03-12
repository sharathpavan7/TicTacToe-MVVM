package com.example.tictactoe_mvvm.viewmodel;

import android.app.Application;
import android.util.ArrayMap;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tictactoe_mvvm.model.Cell;
import com.example.tictactoe_mvvm.model.Game;
import com.example.tictactoe_mvvm.model.Player;
import com.example.tictactoe_mvvm.utils.StringUtils;

public class GameViewmodel extends AndroidViewModel {

    public ArrayMap<String, String> cells;
    private Game game;

    public GameViewmodel(Application application) {
        super(application);
    }

    public void init(String player1, String player2) {
        game = new Game(player1, player2);
        cells = new ArrayMap<>();
    }

    public void onClickedCellAt(int row, int column) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = new Cell(game.currentPlayer);
            cells.put(StringUtils.stringFromNumbers(row, column), game.currentPlayer.value);
            if (game.hasGameEnded())
                game.reset();
            else
                game.switchPlayer();
        }
    }

    public MutableLiveData<Player> getWinnerObserver() {
        return game.winner;
    }
}
