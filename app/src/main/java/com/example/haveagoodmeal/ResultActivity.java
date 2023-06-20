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

    private String[] stages = {
            "stage1_clear",
            "stage2_clear",
            "stage3_clear"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int score10000 = bundle.getInt("score");
        int score100 = Math.round(score10000 / 100f);

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

        nextStage = findViewById(R.id.button_nextstage);
        nextStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
                StageDB.editor = StageDB.sp.edit();

                for (int i = 0; i < 3; i++) {
                    if (!(Boolean) StageDB.sp.getBoolean(stages[i], true)) {
                        Log.i("nextStage", "stage" + i);
                        StageDB.editor.putBoolean(stages[i], true);
                        StageDB.editor.commit();
                        break;
                    }
                }
                startActivity(new Intent(ResultActivity.this, OnGameActivity.class));
            }
        });

        Button buttonHome = (Button) findViewById(R.id.button_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        if (score10000 == 10000) {
            nextStage.setVisibility(View.VISIBLE);
        }

        textScore = findViewById(R.id.text_score);
        if (score10000 < 0)
            textScore.setText("이 음식은 형편없군!");
        if (score10000 == 0)
            textScore.setText("다시 만들어보자");
        if (score10000 > 0)
            textScore.setText("이정도면 " + score100 + " 그릇은 팔리겠는걸?");
        if (score10000 == 10000)
            textScore.setText("완벽한 음식이야!");

    }
}