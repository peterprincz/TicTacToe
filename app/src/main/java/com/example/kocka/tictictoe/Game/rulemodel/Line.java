package com.example.kocka.tictictoe.Game.rulemodel;

import java.util.ArrayList;

/**
 * Created by kocka on 2018.03.13..
 */

public class Line extends TicTacModel{


    public Line(int position) {
        this.position = position;
        this.fields = new ArrayList<>();
    }
}

