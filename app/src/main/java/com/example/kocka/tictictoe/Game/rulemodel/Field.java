package com.example.kocka.tictictoe.Game.rulemodel;

import com.example.kocka.tictictoe.Game.Player;

/**
 * Created by kocka on 2018.03.13..
 */

public class Field {


    private char playerChar;
    private Player player;
    private int position;


    public Field(int position) {
        this.playerChar = ' ';
        this.position = position;
    }

    public void setPlayer(Player player){
        this.player = player;
        this.playerChar = player.getCharacter();
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public void setPlayerChar(char playerChar) {
        this.playerChar = playerChar;
    }

}
