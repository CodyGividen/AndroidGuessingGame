package com.example.codygividen.firstandroidworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private Button playAgainButton;
    private TextView correctNumberTextView;
    private TextView resultsTextView;
    private ImageView resultImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        playAgainButton = findViewById(R.id.restart_button);
        correctNumberTextView = findViewById(R.id.number_textview);
        resultsTextView = findViewById(R.id.results_textview);
        resultImageView = findViewById(R.id. winning_imageview);

        setListener();


    }

    private void setListener() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
