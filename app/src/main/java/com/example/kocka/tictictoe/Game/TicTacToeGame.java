package com.example.kocka.tictictoe.Game;

import com.example.kocka.tictictoe.Game.rulemodel.Field;
import com.example.kocka.tictictoe.Game.rulemodel.Table;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kocka on 2018.03.13..
 */

public class TicTacToeGame {

    protected Table table;

    protected Player player1;
    protected Player player2;
    protected Player currentPlayer;

    public TicTacToeGame(){
        this.table = new Table();
        this.player1 = new Player('X');
        player1.setUserName("X player");
        this.player2 = new Player('O');
        player2.setUserName("O player");
        this.currentPlayer = player1;
    }

    public String turn(int position){

        ArrayList<Field> fields = table.getFields();

        changePlayer();
        if(fields.get(position).getPlayerChar() == ' ' && !isGameover()) {
            table.setField(position, currentPlayer);
            return String.valueOf(currentPlayer.getCharacter());
        }
        //revert
        changePlayer();
        return " ";
    }

    protected void changePlayer() {
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean isGameover() {
        if (table.checkWinner() == 'X' || table.checkWinner() == 'O') {
            return true;
        }
        int count = 0;
        for (Field field:table.getFields()) {
            if(field.getPlayerChar() != ' '){
                count ++;
            }
        }
        return count == 9;
    }

    protected Player getWinner(){

        switch (table.checkWinner()){
            case ' ' : return null;
            case 'X' : return player1;
            case 'O' :return player2;
        }
        throw new IllegalStateException("checkwinner Didn't return a valid char");
    }

    public GameState getGamestate(){
        String fieldString = "";
        for (Field field:table.getFields()) {
            if(field.getPlayerChar() == ' '){
                fieldString += "-";
            } else {
                fieldString += String.valueOf(field.getPlayerChar());
            }
        }

        GameState gameState = new GameState(fieldString, currentPlayer, getWinner(), isGameover());
        return gameState;
    }

}
