package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class OnGameActivity extends AppCompatActivity {

    private static final int NUM_OF_INGREDIENTS = 28;
    private static final String[] ingredientNames = {
            "water",
            "salt",
            "sugar",
            "soysauce",
            "pepperpaste",
            "pepperpowder",
            "syrup",
            "oligo",
            "sesameoil",
            "pepper",
            "mayo",
            "jam",
            /* 12 things */

            "carrot",
            "onion",
            "greenonion",
            "leek",
            "tofu",
            "cucumber",
            "tomato",
            "egg",
            "seaweed",
            "potato",
            "sweetpotato",
            "doubanjiang",
            "meat",
            "tuna",
            "vegetable1",
            "vegetable2"
            /* 16 things */
    };
    private static final int[][] ingredientAnswers = {
            {},
            {
                    /* stage 1 */
                    0, /* water */
                    3, /* salt */
                    4, /* sugar */
                    0, /* soysauce */
                    0, /* pepperpaste */
                    0, /* pepperpowder */
                    0, /* syrup */
                    0, /* oligo */
                    0, /* sesameoil */
                    0, /* pepper */
                    0, /* mayo */
                    0, /* jam */

                    0, /* carrot */
                    0, /* onion */
                    0, /* greenonion */
                    0, /* leek */
                    0, /* tofu */
                    0, /* cucumber */
                    0, /* tomato */
                    0, /* egg */
                    0, /* seaweed */
                    0, /* potato */
                    0, /* sweetpotato */
                    0, /* doubanjiang */
                    0, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */

            },
            {
                    /* stage 2 */
                    0, /* water */
                    2, /* salt */
                    2, /* sugar */
                    0, /* soysauce */
                    0, /* pepperpaste */
                    0, /* pepperpowder */
                    0, /* syrup */
                    0, /* oligo */
                    0, /* sesameoil */
                    0, /* pepper */
                    0, /* mayo */
                    0, /* jam */

                    0, /* carrot */
                    0, /* onion */
                    0, /* greenonion */
                    0, /* leek */
                    0, /* tofu */
                    0, /* cucumber */
                    0, /* tomato */
                    0, /* egg */
                    0, /* seaweed */
                    0, /* potato */
                    0, /* sweetpotato */
                    0, /* doubanjiang */
                    0, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */
            },
            {
                    /* stage 3 */
                    0, /* water */
                    5, /* salt */
                    2, /* sugar */
                    0, /* soysauce */
                    0, /* pepperpaste */
                    0, /* pepperpowder */
                    0, /* syrup */
                    0, /* oligo */
                    0, /* sesameoil */
                    0, /* pepper */
                    0, /* mayo */
                    0, /* jam */

                    0, /* carrot */
                    0, /* onion */
                    0, /* greenonion */
                    0, /* leek */
                    0, /* tofu */
                    0, /* cucumber */
                    0, /* tomato */
                    0, /* egg */
                    0, /* seaweed */
                    0, /* potato */
                    0, /* sweetpotato */
                    0, /* doubanjiang */
                    0, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */
            }
    };
    private static final float[][] ingredientScores = {
            {},
            {
                    /* stage 1 */
                    0, /* water */
                    2000, /* salt */
                    1000, /* sugar */
                    0, /* soysauce */
                    0, /* pepperpaste */
                    0, /* pepperpowder */
                    0, /* syrup */
                    0, /* oligo */
                    0, /* sesameoil */
                    0, /* pepper */
                    0, /* mayo */
                    0, /* jam */

                    0, /* carrot */
                    0, /* onion */
                    0, /* greenonion */
                    0, /* leek */
                    0, /* tofu */
                    0, /* cucumber */
                    0, /* tomato */
                    0, /* egg */
                    0, /* seaweed */
                    0, /* potato */
                    0, /* sweetpotato */
                    0, /* doubanjiang */
                    0, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */

            },
            {
                    /* stage 2 */
                    0, /* water */
                    3, /* salt */
                    4, /* sugar */
                    0, /* soysauce */
                    0, /* pepperpaste */
                    0, /* pepperpowder */
                    0, /* syrup */
                    0, /* oligo */
                    0, /* sesameoil */
                    0, /* pepper */
                    0, /* mayo */
                    0, /* jam */

                    0, /* carrot */
                    0, /* onion */
                    0, /* greenonion */
                    0, /* leek */
                    0, /* tofu */
                    0, /* cucumber */
                    0, /* tomato */
                    0, /* egg */
                    0, /* seaweed */
                    0, /* potato */
                    0, /* sweetpotato */
                    0, /* doubanjiang */
                    0, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */

            },
            {
                    /* stage 3 */
                    0, /* water */
                    5, /* salt */
                    3, /* sugar */
                    0, /* soysauce */
                    0, /* pepperpaste */
                    0, /* pepperpowder */
                    0, /* syrup */
                    0, /* oligo */
                    0, /* sesameoil */
                    0, /* pepper */
                    0, /* mayo */
                    0, /* jam */

                    0, /* carrot */
                    0, /* onion */
                    0, /* greenonion */
                    0, /* leek */
                    0, /* tofu */
                    0, /* cucumber */
                    0, /* tomato */
                    0, /* egg */
                    0, /* seaweed */
                    0, /* potato */
                    0, /* sweetpotato */
                    0, /* doubanjiang */
                    0, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */

            }
    };

    private static int stage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);

        Map<String, Integer> ingredientValues = new HashMap<>(NUM_OF_INGREDIENTS);
        for (String str : ingredientNames)
            ingredientValues.put(str, 0);

        TextView text = findViewById(R.id.text);

        Button buttonWater = findViewById(R.id.button_water);
        buttonWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientValues.put("water", ingredientValues.get("water") + 1);
                text.setText("water");
            }
        });

        Button buttonSalt = findViewById(R.id.button_salt);
        buttonSalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientValues.put("salt", ingredientValues.get("salt") + 1);
                text.setText("salt");
            }
        });

        Button buttonCarrot = findViewById(R.id.button_carrot);
        buttonCarrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientValues.put("carrot", ingredientValues.get("carrot") + 1);
                text.setText("carrot");
            }
        });

        Button buttonOnion = findViewById(R.id.button_onion);
        buttonOnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientValues.put("onion", ingredientValues.get("onion") + 1);
                text.setText("onion");
            }
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 10000, temp;

                for (int i = 0; i < NUM_OF_INGREDIENTS; i++) {
                    temp = ingredientValues.getOrDefault(ingredientNames[i], 0) - ingredientAnswers[stage][i];
                    if (temp < 0) temp = -temp;
                    score -= temp * ingredientScores[stage][i];
                }

                Bundle bundle = new Bundle();
                bundle.putInt("score", score);

                Intent intent = new Intent(OnGameActivity.this, ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}