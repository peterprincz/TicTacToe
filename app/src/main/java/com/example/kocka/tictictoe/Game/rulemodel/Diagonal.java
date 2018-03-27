package com.example.kocka.tictictoe.Game.rulemodel;

import java.util.ArrayList;

/**
 * Created by kocka on 2018.03.13..
 */

public class Diagonal  extends TicTacModel{

    public Diagonal(int position) {
        this.position = position;
        this.fields = new ArrayList<>();
    }

}
