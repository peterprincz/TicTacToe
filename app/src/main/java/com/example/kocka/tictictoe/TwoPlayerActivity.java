package com.example.kocka.tictictoe;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.kocka.tictictoe.Game.Player;
import com.example.kocka.tictictoe.Game.TicTacToeGame;
import com.example.kocka.tictictoe.Game.TicTacToeGameWAI;

import java.util.ArrayList;
import java.util.List;

public class TwoPlayerActivity extends AppCompatActivity {

    TicTacToeGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_player_activity);
        Bundle bundle = getIntent().getExtras();
        if(bundle.get("gameType").equals("AI")){
            this.game = new TicTacToeGameWAI(this);
        } else {
            this.game = new TicTacToeGame();
        }
        setButtonFields();
    }

    protected void setButtonFields() {
        List<Button> buttonList = getAllFields();
        for(Button button: buttonList){
            button.setText(" ");
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View button) {
                    turn((Button) button);
                }
            });
        }
    }



    private void turn(Button button) {
        Button actbutton = button;
        String actbuttonFullId = getResources().getResourceEntryName(actbutton.getId());
        String actbuttonId = actbuttonFullId.substring(actbuttonFullId.length() - 1);
        game.turn(Integer.parseInt(actbuttonId));
        refreshTable();
        checkWinner();
    }

    public void checkWinner() {
        if(game.getGamestate().isGameOver()){
            Player winner = game.getGamestate().getWinner();
            AlertDialog ad = alertWinner(winner, TwoPlayerActivity.this);
            ad.setTitle("The game is over");
            ad.show();
        }
    }

    public void refreshTable(){
        String gameState = game.getGamestate().getGameString();
        List<Button> buttons = getAllFields();
        for(int i = 0;i < buttons.size();i++){
            if(gameState.charAt(i) == '-'){
                buttons.get(i).setText(" ");
            } else {
                buttons.get(i).setText(String.valueOf(gameState.charAt(i)));
            }
        }
    }

    protected AlertDialog alertWinner(Player winner, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String txt;
        if(winner != null){
            txt = winner.getUserName() + " has won the game";
        }
        else{
            txt = "The game is draw";
        }
        builder.setMessage(txt);
        builder.setPositiveButton("new Game", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                newGame();
            }
        });
        builder.setNegativeButton("Back to the menu",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                final Intent mainMenuIntent = new Intent(TwoPlayerActivity.this, MainMenuActivity.class);

                startActivity(mainMenuIntent);
            }
        });
        return builder.create();
    }

    protected List<Button> getAllFields(){
        List<Button> buttonList = new ArrayList<>();
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < tableRow.getChildCount(); j++) {
                Button button = (Button) tableRow.getChildAt(j);
                if(button != null) {
                    buttonList.add(button);
                } else {
                    throw new NullPointerException("Button is missing from the table");
                }
            }
        }
        return buttonList;
    }

    protected void newGame(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }



}
