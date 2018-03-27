package com.example.kocka.tictictoe.Game;

import android.support.annotation.Nullable;

/**
 * Created by kocka on 2018.03.14..
 */

public class GameState {


    private String gameString;
    private Player winner;
    private boolean GameOver;
    private Player currentplayer;

    public GameState(String gameString, Player currentplayer, Player winner, boolean isGameOver) {
        this.gameString = gameString;
        if(isGameOver){
            this.winner = winner;
        } else {
            System.out.println("There is no winner");
            this.winner = new Player(' ');
        }
        this.GameOver = isGameOver;
        this.currentplayer = currentplayer;
    }

    public String getGameString() {
        return gameString;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return GameOver;
    }

    public Player getCurrentplayer() {
        return currentplayer;
    }

    public boolean isGameover(){
        return this.GameOver;
    }
}

