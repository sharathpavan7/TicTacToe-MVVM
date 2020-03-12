package com.example.tictactoe_mvvm.model;

import com.example.tictactoe_mvvm.utils.StringUtils;

public class Cell {
    public Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null || StringUtils.isNullorEmpty(player.value);
    }
}
