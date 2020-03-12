package com.example.tictactoe_mvvm.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tictactoe_mvvm.model.Cell;
import com.example.tictactoe_mvvm.model.Game;
import com.example.tictactoe_mvvm.model.Player;

public class GameViewmodel extends AndroidViewModel {

    private Game game;

    public GameViewmodel(Application application) {
        super(application);
    }

    public void init(String player1, String player2) {
        game = new Game(player1, player2);
    }

    public void onClickedCellAt(int row, int column) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = new Cell(game.currentPlayer);
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
