package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);

        TextView text = findViewById(R.id.text);

        Button buttonWater = findViewById(R.id.button_water);
        buttonWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Water");
            }
        });

        Button buttonSalt = findViewById(R.id.button_salt);
        buttonSalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Salt");
            }
        });

        Button buttonCarrot = findViewById(R.id.button_carrot);
        buttonCarrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Carrot");
            }
        });

        Button buttonOnion = findViewById(R.id.button_onion);
        buttonOnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Onion");
            }
        });

    }
}