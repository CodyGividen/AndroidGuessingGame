package com.example.codygividen.firstandroidworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame();
    }
    private void startGame(){
        Intent playGame = new Intent(this, GameActivity.class);
        startActivity(playGame);
    }
}