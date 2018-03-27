package com.example.kocka.tictictoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        Button twoPlayerButton = findViewById(R.id.buttonTwoPlayer);
        final Intent twoPlayerIntent = new Intent(this, TwoPlayerActivity.class);
        Bundle twoPlayerBundle = new Bundle();
        twoPlayerBundle.putString("gameType", "TwoPlayer");
        twoPlayerIntent.putExtras(twoPlayerBundle);
        twoPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(twoPlayerIntent);
            }
        });

        Button AIGameButton = findViewById(R.id.buttonAIGame);
        Bundle AIGameBundle = new Bundle();
        AIGameBundle.putString("gameType", "AI");
        final Intent AIGameIntent = new Intent(this, TwoPlayerActivity.class);
        AIGameIntent.putExtras(AIGameBundle);
        AIGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AIGameIntent);
            }
        });
    }
}
