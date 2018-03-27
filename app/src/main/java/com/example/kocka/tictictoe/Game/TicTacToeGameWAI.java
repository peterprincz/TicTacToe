package com.example.kocka.tictictoe.Game;

import android.app.ProgressDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kocka.tictictoe.Game.rulemodel.Field;
import com.example.kocka.tictictoe.TwoPlayerActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kocka on 2018.03.13..
 */

public class TicTacToeGameWAI extends TicTacToeGame {

    TwoPlayerActivity context;
    boolean isAIpiciking;

    public TicTacToeGameWAI(TwoPlayerActivity context){
        super();
        this.context = context;
        isAIpiciking = false;
    }

    @Override
    public String turn(int position){
        System.out.println(isAIpiciking);
        ArrayList<Field> fields = table.getFields();
        if (fields.get(position).getPlayerChar() == ' ' && !isGameover()) {
            table.setField(position, currentPlayer);
            if(!isGameover()) {
                changePlayer();
                getAIMove();
            }

            return String.valueOf(currentPlayer.getCharacter());
        }
        return " ";
    }

    private void getAIMove() {
        this.isAIpiciking = true;
        final ProgressDialog dialog=new ProgressDialog(context);
        dialog.setMessage("The AI is thinking");
        dialog.setCancelable(false);
        dialog.setInverseBackgroundForced(false);
        dialog.show();
        String url = "http://tttapi.herokuapp.com/api/v1/" + this.getGamestate().getGameString() + "/O";
        RequestQueue rq = Volley.newRequestQueue(context);
        JsonObjectRequest jor = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            String aiMove = jsonObject.get("recommendation").toString();
                            table.setField(Integer.parseInt(aiMove), currentPlayer);
                            changePlayer();
                            isAIpiciking = false;
                            dialog.hide();
                            context.refreshTable();
                            context.checkWinner();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                }
        );
        jor.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 100000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 100000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        rq.add(jor);
    }


}
