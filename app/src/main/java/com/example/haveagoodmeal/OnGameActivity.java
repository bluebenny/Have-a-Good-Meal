package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OnGameActivity extends AppCompatActivity {

    class RotateImageViewer {

        int[] ids = new int[8];

        ImageView[] images = new ImageView[] {
                (ImageView) findViewById(R.id.ingredient8),
                (ImageView) findViewById(R.id.ingredient7),
                (ImageView) findViewById(R.id.ingredient6),
                (ImageView) findViewById(R.id.ingredient5),
                (ImageView) findViewById(R.id.ingredient4),
                (ImageView) findViewById(R.id.ingredient3),
                (ImageView) findViewById(R.id.ingredient2),
                (ImageView) findViewById(R.id.ingredient1)
        };

        RotateImageViewer() {}

        public void setImage(int id) {
            for (int i = 7; i > 0; i--)
                ids[i] = ids[i - 1];
            ids[0] = id;

            for (int i = 0; i < 8; i++)
                images[i].setImageResource(ids[i]);
        }

    }

    Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);

        RotateImageViewer rotateImageViewer = new RotateImageViewer();

        TextView text = findViewById(R.id.text);

        Button buttonWater = findViewById(R.id.button_water);
        buttonWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score += 5;
            }
        });

        Button buttonSalt = findViewById(R.id.button_salt);
        buttonSalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Salt");
                rotateImageViewer.setImage(R.drawable.image_salt);
                score += 10;
            }
        });

        Button buttonCarrot = findViewById(R.id.button_carrot);
        buttonCarrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Carrot");
                rotateImageViewer.setImage(R.drawable.image_carrot);
                score += 10;
            }
        });

        Button buttonOnion = findViewById(R.id.button_onion);
        buttonOnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Onion");
                rotateImageViewer.setImage(R.drawable.image_onion);
                score += 10;
            }
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("score", score);

                Intent intent = new Intent(OnGameActivity.this, ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}