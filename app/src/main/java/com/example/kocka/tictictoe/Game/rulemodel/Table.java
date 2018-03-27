package com.example.kocka.tictictoe.Game.rulemodel;

import com.example.kocka.tictictoe.Game.Player;

import java.util.ArrayList;

/**
 * Created by kocka on 2018.03.13..
 */

public class Table {

    private ArrayList<ArrayList<TicTacModel>> ticTacModels;
    private ArrayList<TicTacModel> rows;
    private ArrayList<TicTacModel> lines;
    private ArrayList<TicTacModel> diagonals;
    private ArrayList<Field> fields;


    public Table() {
        this.fields = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.diagonals = new ArrayList<>();
        this.ticTacModels = new ArrayList<>();
        ticTacModels.add(rows);
        ticTacModels.add(lines);
        ticTacModels.add(diagonals);

        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                this.diagonals.add(new Diagonal(i));
            }
            this.lines.add(new Line(i));
            this.rows.add(new Row(i));
        }

        for (int i = 0; i < 9; i++) {
            Field newField = new Field(i);
            this.fields.add(newField);
            this.lines.get(i / 3).Addfield(newField);
            this.rows.get((i + 3) % 3).Addfield(newField);
            if ((i + 4) % 4 == 0) {
                this.diagonals.get(0).Addfield(newField);
            }
            if (i > 1 && i < 8 && i % 2 == 0) {
                this.diagonals.get(1).Addfield(newField);
            }
        }

    }

    public char checkWinner(){
        for (ArrayList<TicTacModel> ticTacModels:ticTacModels) {
            for (TicTacModel ticTacModel:ticTacModels){
                if(ticTacModel.checkWinner() != ' '){
                    return ticTacModel.checkWinner();
                }
            }
        }
        return ' ';
    }

    public ArrayList<Field> getFields() {
        return fields;
    }


    public void setField(int position, Player player){
        Field field = this.fields.get(position);
        field.setPlayer(player);
    }
}