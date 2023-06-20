package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class StartActivity extends AppCompatActivity {
    private ImageView startImageView;
    private ImageView titleImageView;

    private  Button button;

    // StageDB 사용시 배열 인덱스를 이용해 반복문을 사용하기 위해 사용
    private String[] stages = {
            "stage1_clear",
            "stage2_clear",
            "stage3_clear"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 앱이 설치 후 처음 실행되어 스테이지 DB가 처음으로 불리는지 확인한 정보를 boolean 변수에 저장함
        SharedPreferences pref = getSharedPreferences("isFirst", MODE_PRIVATE);
        boolean first = pref.getBoolean("isFirst", false);

        // 변수가 앱이 처음 실행되었을 때 전체 스테이지의 클리어 정보를 false로 초기화 함
        if (first == false) {
            Log.d("Is first Time?", "first");
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("isFirst",true); // 다음에 실행 시 스테이지 클리어 정보가 초기화되지 않도록 함
            editor.commit();
            for (int i = 0; i < 3; i++) {
                StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
                StageDB.editor = StageDB.sp.edit();
                StageDB.editor.putBoolean(stages[i], false);
                StageDB.editor.commit();
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // 화면이 전체 화면이 되도록 하는 코드
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitynext();
            }
        });


    }

    public void openActivitynext() {
        Intent intent = new Intent(this, OnGameActivity.class);
        startActivity(intent);

    }

}