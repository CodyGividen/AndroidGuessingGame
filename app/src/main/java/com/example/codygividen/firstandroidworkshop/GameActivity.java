package com.example.codygividen.firstandroidworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends AppCompatActivity {
    @BindView(R.id.clue_textView)
    protected TextView clueTextView;
    @BindView(R.id.guess_edittext)
    protected EditText guess;

    private int randonumber;
    private int numberOfGuess = 0;
    private final int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        randonumber = (int) Math.ceil(Math.random() * 100);
        numberOfGuess = 0;
        clueTextView.setVisibility(View.INVISIBLE);
        guess.setText("");
    }
    @OnClick(R.id.submit_guess_button)
    protected void validateGuess() {
                int userGuess = Integer.parseInt(guess.getText().toString());
                if (userGuess > 100) {
                    clueTextView.setText(R.string.invalid_number_message);
                    clueTextView.setVisibility(View.VISIBLE);
                    guess.setText("");
                } else {
                    checkGuess(userGuess);
                }

            }

    private void checkGuess(int userGuess) {
        if (userGuess == randonumber) {
            Intent winner = new Intent(this, ResultsActivity.class);
            startActivity(winner);
        } else if (numberOfGuess == MAX_GUESS_COUNT) {
            Intent loser = new Intent(this, ResultsActivity.class);
            loser.putExtra("WINNING_NUMBER", randonumber);
            startActivity(loser);
        } else if (userGuess > randonumber) {
            clueTextView.setText("your number is to high");
            numberOfGuess++;
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
        } else if (userGuess < randonumber)

        {
            clueTextView.setText("Your number is too low!");
            numberOfGuess++;
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");

        }
    }
        @Override
        public void onBackPressed(){
        }
}
