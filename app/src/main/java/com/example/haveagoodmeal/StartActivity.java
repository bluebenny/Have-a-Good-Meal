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

    private String[] stages = {
            "stage1_clear",
            "stage2_clear",
            "stage3_clear"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences pref = getSharedPreferences("isFirst", MODE_PRIVATE);
        boolean first = pref.getBoolean("isFirst", false);

        if (first == false) {
            Log.d("Is first Time?", "first");
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("isFirst",true);
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