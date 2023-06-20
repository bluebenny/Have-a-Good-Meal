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

    // StageDB 사용시 배열 인덱스를 이용해 반복문을 사용하기 위해 사용
    private String[] stages = {
            "stage1_clear",
            "stage2_clear",
            "stage3_clear"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 화면이 전체 화면이 되도록 하는 코드
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 인텐트로 넘겨받은 점수 정보를 로컬 변수에 저장함
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int score10000 = bundle.getInt("score");
        int score100 = Math.round(score10000 / 100f);

        // 스테이지 다시 시도하기 버튼
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
                // 스테이지 DB를 사용하기 위해 SharedPreference 사용
                StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
                StageDB.editor = StageDB.sp.edit();

                // 낮은 스테이지부터 시작해 처음으로 false가 되는 스테이지 클리어 정보를 true로 설정하여
                // 하나의 스테이지가 클리어되도록 설정
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

        // 시작 화면으로 돌아가기 위한 버튼
        Button buttonHome = (Button) findViewById(R.id.button_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        // 최대 점수를 받았을 경우 다음 난이도의 스테이지에 도전할 수 있음
        if (score10000 == 10000) {
            nextStage.setVisibility(View.VISIBLE);
        }

        // 점수에 따른 출력문. 플레이어에게 보이는 점수는 최대 100점인 점수이며, 실제 계산에 사용되는 점수는 최대 10000점인 점수임
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