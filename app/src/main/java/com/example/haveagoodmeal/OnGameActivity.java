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

        int[] ids = new int[20];

        ImageView[] images = new ImageView[] {
                (ImageView) findViewById(R.id.ingredient20),
                (ImageView) findViewById(R.id.ingredient19),
                (ImageView) findViewById(R.id.ingredient18),
                (ImageView) findViewById(R.id.ingredient17),
                (ImageView) findViewById(R.id.ingredient16),
                (ImageView) findViewById(R.id.ingredient15),
                (ImageView) findViewById(R.id.ingredient14),
                (ImageView) findViewById(R.id.ingredient13),
                (ImageView) findViewById(R.id.ingredient12),
                (ImageView) findViewById(R.id.ingredient11),
                (ImageView) findViewById(R.id.ingredient10),
                (ImageView) findViewById(R.id.ingredient9),
                (ImageView) findViewById(R.id.ingredient8),
                (ImageView) findViewById(R.id.ingredient7),
                (ImageView) findViewById(R.id.ingredient6),
                (ImageView) findViewById(R.id.ingredient5),
                (ImageView) findViewById(R.id.ingredient4),
                (ImageView) findViewById(R.id.ingredient3),
                (ImageView) findViewById(R.id.ingredient2),
                (ImageView) findViewById(R.id.ingredient1)
        };

        ImageView[] layerImages = new ImageView[] {
                (ImageView) findViewById(R.id.ingredient_layer1),
                (ImageView) findViewById(R.id.ingredient_layer2),
                (ImageView) findViewById(R.id.ingredient_layer3),
                (ImageView) findViewById(R.id.ingredient_layer4),
                (ImageView) findViewById(R.id.ingredient_layer5),
                (ImageView) findViewById(R.id.ingredient_layer6),
                (ImageView) findViewById(R.id.ingredient_layer7),
                (ImageView) findViewById(R.id.ingredient_layer8)
        };

        RotateImageViewer() {}

        public void setImage(int id) {
            for (int i = 19; i > 0; i--)
                ids[i] = ids[i - 1];
            ids[0] = id;

            for (int i = 0; i < 20; i++)
                images[i].setImageResource(ids[i]);
        }

        public void setImage(int id, String layerType) {
            setImage(id);

            if (layerType.equals("tuna"))
                layerImages[0].setImageResource(id);
            if (layerType.equals("meat"))
                layerImages[1].setImageResource(id);
            if (layerType.equals("seaweed"))
                layerImages[2].setImageResource(id);
            if (layerType.equals("stick"))
                layerImages[3].setImageResource(id);
            if (layerType.equals("circle"))
                layerImages[4].setImageResource(id);
            if (layerType.equals("cubic"))
                layerImages[5].setImageResource(id);
            if (layerType.equals("sauce"))
                layerImages[6].setImageResource(id);
            if (layerType.equals("normal"))
                layerImages[7].setImageResource(id);
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
                rotateImageViewer.setImage(R.drawable.image_carrot, "stick");
                score += 10;
            }
        });

        Button buttonOnion = findViewById(R.id.button_onion);
        buttonOnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Onion");
                rotateImageViewer.setImage(R.drawable.image_onion, "stick");
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