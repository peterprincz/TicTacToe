package com.example.kocka.tictictoe.Game;

/**
 * Created by kocka on 2018.03.13..
 */

public class Player {
    private String userName = "Anonymous";

    private char character;

    public Player(char character){
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
