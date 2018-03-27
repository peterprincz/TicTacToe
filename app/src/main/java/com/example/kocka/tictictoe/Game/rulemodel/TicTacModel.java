package com.example.kocka.tictictoe.Game.rulemodel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kocka on 2018.03.13..
 */

public abstract class  TicTacModel {

    public ArrayList<Field> fields;

    int position;

    public char checkWinner(){

        ArrayList<String> chars = new ArrayList<>();

        for (Field field:fields) {
            chars.add(String.valueOf(field.getPlayerChar()));
        }

        if(chars.equals(Arrays.asList("O", "O", "O"))) {
            return 'O';
        }
        if(chars.equals(Arrays.asList("X", "X", "X"))) {
            return 'X';
        }

        return ' ';

    }

    public void Addfield(Field field){
        this.fields.add(field);
    }


}