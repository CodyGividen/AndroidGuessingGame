package com.example.codygividen.firstandroidworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView clueTextView;
    private Button guessButton;
    private EditText guess;
    private int randonumber;
    private int numberOfGuess = 0;
    private final int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextView = findViewById(R.id.clue_textView);
        guessButton = findViewById(R.id.submit_guess_button);
        guess = findViewById(R.id.guess_edittext);
        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        randonumber = (int) Math.ceil(Math.random() * 100);
    }

    private void setListener(){
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(guess.getText().toString());
                if(userGuess > 100) {
                    clueTextView.setText(R.string.invalid_number_message);
                    clueTextView.setVisibility(View.VISIBLE);
                    guess.setText("");
                }else {
                    checkGuess(userGuess);
                }

            }
        });
    }
    private void checkGuess(int userGuess){

        if (userGuess > randonumber) {
            clueTextView.setText("your number is to high");
            numberOfGuess = (numberOfGuess + 1);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
        } else if (userGuess < randonumber) {
            clueTextView.setText("Your number is too low!");
            numberOfGuess = (numberOfGuess + 1);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
        } else if (userGuess == randonumber) {
            //TODO -create intent to go to winning activity - handle winning
        }else if (userGuess == MAX_GUESS_COUNT){
            //TODO -create intent to go to winning activity - handle out of chances
        }
    }
    @Override
    public void onBackPressed() {
    }
}
