package com.example.motionmasters.motionmasters;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Button blowMasterButton = findViewById(R.id.blowMasterButton);
        blowMasterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StartGameActivityBlow.class);
                startActivity(intent);
            }
        });

        Button jumpMasterButton = findViewById(R.id.jumpMasterButton);
        jumpMasterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), JumpActivity.class);
                startActivity(intent);
            }
        });

        Button throwMasterButton = findViewById(R.id.throwMasterButton);
        throwMasterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ThrowActivity.class);
                startActivity(intent);
            }
        });

        Button highscoreButton = findViewById(R.id.highscoreButton);
        highscoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HighScoreActivity.class);
                intent.putExtra("game", "main");
                startActivity(intent);
            }
        });
    }
}
