package com.example.kocka.tictictoe.Game.rulemodel;

import java.util.ArrayList;

/**
 * Created by kocka on 2018.03.13..
 */

public class Row extends TicTacModel {

    public Row(int position) {
        this.position = position;
        this.fields = new ArrayList<>();
    }
}

