package com.example.motionmasters.motionmasters;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class JumpScoreActivity extends AppCompatActivity {
    private EditText name;
    private TextView result;
    private Button jumpScoreButton;
    private double score;
    private String game;
    private DecimalFormat decimalFormat;
    private HighScoreDatabase helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumpscore);
        name = findViewById(R.id.jumpName);
        result = findViewById(R.id.jump_ingame_result);
        jumpScoreButton = findViewById(R.id.jumpScoreButton);
        decimalFormat = new DecimalFormat("0.00");
        game = "Jumpmaster";
        Intent receiveIntent = getIntent();
        score = receiveIntent.getDoubleExtra("score", 0.0);
        result.setText("You jumped: " + score + "m");
        helper = new HighScoreDatabase(this);


        jumpScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(JumpScoreActivity.this, HighScoreActivity.class);
                intent.putExtra("score",score);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("game",game);
                Log.d("name", name.getText().toString());
                Log.d("score", Double.toString(score));
                Log.d("game", game);
                helper.insertData(name.getText().toString(), score, game);
                startActivity(intent);
            }
        });

    }

}
