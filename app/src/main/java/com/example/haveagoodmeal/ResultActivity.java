package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button next, nextStage;
    private TextView textScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int score = bundle.getInt("score");
        score = Math.round(score / 100f);

        next = findViewById(R.id.button_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, OnGameActivity.class));
            }
        });

        nextStage = findViewById(R.id.button_nextstage);
        nextStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        if (score == 100) {
            nextStage.setVisibility(View.VISIBLE);
        }

        textScore = findViewById(R.id.text_score);
        if (score < 0)
            textScore.setText("이 음식은 형편없군!");
        if (score == 0)
            textScore.setText("다시 만들어보자");
        if (score > 0)
            textScore.setText("이정도면 " + score + " 그릇은 팔리겠는걸?");
        if (score == 100)
            textScore.setText("완벽한 음식이야!");

    }
}