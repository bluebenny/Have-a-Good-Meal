package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

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

    Integer score = 0;
    private static int stage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);

        RotateImageViewer rotateImageViewer = new RotateImageViewer();

        Map<String, Integer> ingredientValues = new HashMap<>(NUM_OF_INGREDIENTS);
        for (String str : ingredientNames)
            ingredientValues.put(str, 0);

        /* ingredient buttons (28 things) */
        {
            Button buttonWater = findViewById(R.id.button_water);
            buttonWater.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("water", ingredientValues.get("water") + 1);
                }
            });

            Button buttonSalt = findViewById(R.id.button_salt);
            buttonSalt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("salt", ingredientValues.get("salt") + 1);
                    rotateImageViewer.setImage(R.drawable.image_salt);
                }
            });

            Button buttonSugar = findViewById(R.id.button_sugar);
            buttonSugar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("sugar", ingredientValues.get("sugar") + 1);
                    rotateImageViewer.setImage(R.drawable.image_sugar);
                }
            });

            Button buttonSoySauce = findViewById(R.id.button_soysauce);
            buttonSoySauce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("soysauce", ingredientValues.get("soysauce") + 1);
                    rotateImageViewer.setImage(R.drawable.image_soysauce);
                }
            });

            Button buttonPepperPaste = findViewById(R.id.button_pepperpaste);
            buttonPepperPaste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("pepperpaste", ingredientValues.get("pepperpaste") + 1);
                    rotateImageViewer.setImage(R.drawable.image_pepperpaste);
                }
            });

            Button buttonPepperPowder = findViewById(R.id.button_pepperpowder);
            buttonPepperPowder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("pepperpowder", ingredientValues.get("pepperpowder") + 1);
                    rotateImageViewer.setImage(R.drawable.image_pepperpowder);
                }
            });

            Button buttonSyrup = findViewById(R.id.button_syrup);
            buttonSyrup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("syrup", ingredientValues.get("syrup") + 1);
                    rotateImageViewer.setImage(R.drawable.image_syrup);
                }
            });

            Button buttonOligo = findViewById(R.id.button_oligo);
            buttonOligo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("oligo", ingredientValues.get("oligo") + 1);
                    rotateImageViewer.setImage(R.drawable.image_oligo);
                }
            });

            Button buttonSesameOil = findViewById(R.id.button_sesameoil);
            buttonSesameOil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("sesameoil", ingredientValues.get("sesameoil") + 1);
                    rotateImageViewer.setImage(R.drawable.image_sesameoil);
                }
            });

            Button buttonPepper = findViewById(R.id.button_pepper);
            buttonPepper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("pepper", ingredientValues.get("pepper") + 1);
                    rotateImageViewer.setImage(R.drawable.image_pepper);
                }
            });

            Button buttonMayo = findViewById(R.id.button_mayo);
            buttonMayo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("mayo", ingredientValues.get("mayo") + 1);
                    rotateImageViewer.setImage(R.drawable.image_mayo);
                }
            });

            Button buttonJam = findViewById(R.id.button_jam);
            buttonJam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("jam", ingredientValues.get("jam") + 1);
                    rotateImageViewer.setImage(R.drawable.image_jam);
                }
            });

            Button buttonCarrot = findViewById(R.id.button_carrot);
            buttonCarrot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("carrot", ingredientValues.get("carrot") + 1);
                    rotateImageViewer.setImage(R.drawable.image_carrot);
                }
            });

            Button buttonOnion = findViewById(R.id.button_onion);
            buttonOnion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("onion", ingredientValues.get("onion") + 1);
                    rotateImageViewer.setImage(R.drawable.image_onion);
                }
            });

            Button buttonGreenOnion = findViewById(R.id.button_greenonion);
            buttonGreenOnion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("greenonion", ingredientValues.get("greenonion") + 1);
                    rotateImageViewer.setImage(R.drawable.image_greenonion);
                }
            });

            Button buttonLeek = findViewById(R.id.button_leek);
            buttonLeek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("leek", ingredientValues.get("leek") + 1);
                    rotateImageViewer.setImage(R.drawable.image_leek);
                }
            });

            Button buttonTofu = findViewById(R.id.button_tofu);
            buttonTofu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("tofu", ingredientValues.get("tofu") + 1);
                    rotateImageViewer.setImage(R.drawable.image_tofu);
                }
            });

            Button buttonCucumber = findViewById(R.id.button_cucumber);
            buttonCucumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("cucumber", ingredientValues.get("cucumber") + 1);
                    rotateImageViewer.setImage(R.drawable.image_cucumber);
                }
            });

            Button buttonTomato = findViewById(R.id.button_tomato);
            buttonTomato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("tomato", ingredientValues.get("tomato") + 1);
                    rotateImageViewer.setImage(R.drawable.image_tomato);
                }
            });

            Button buttonEgg = findViewById(R.id.button_egg);
            buttonEgg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("egg", ingredientValues.get("egg") + 1);
                    rotateImageViewer.setImage(R.drawable.image_egg);
                }
            });

            Button buttonSeaweed = findViewById(R.id.button_seaweed);
            buttonSeaweed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("seaweed", ingredientValues.get("seaweed") + 1);
                    rotateImageViewer.setImage(R.drawable.image_seaweed);
                }
            });

            Button buttonPotato = findViewById(R.id.button_potato);
            buttonPotato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("potato", ingredientValues.get("potato") + 1);
                    rotateImageViewer.setImage(R.drawable.image_potato);
                }
            });

            Button buttonSweetPotato = findViewById(R.id.button_sweetpotato);
            buttonSweetPotato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("sweetpotato", ingredientValues.get("sweetpotato") + 1);
                    rotateImageViewer.setImage(R.drawable.image_sweetpotato);
                }
            });

            Button buttonDoubanjiang = findViewById(R.id.button_doubanjiang);
            buttonDoubanjiang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("doubanjiang", ingredientValues.get("doubanjiang") + 1);
                    rotateImageViewer.setImage(R.drawable.image_doubanjiang);
                }
            });

            Button buttonMeat = findViewById(R.id.button_meat);
            buttonMeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("meat", ingredientValues.get("meat") + 1);
                    rotateImageViewer.setImage(R.drawable.image_meat);
                }
            });

            Button buttonTuna = findViewById(R.id.button_tuna);
            buttonTuna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("tuna", ingredientValues.get("tuna") + 1);
                    rotateImageViewer.setImage(R.drawable.image_tuna);
                }
            });

            Button buttonVegetable1 = findViewById(R.id.button_vegetable1);
            buttonVegetable1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("vegetable1", ingredientValues.get("vegetable1") + 1);
                    rotateImageViewer.setImage(R.drawable.image_vegetable1);
                }
            });

            Button buttonVegetable2 = findViewById(R.id.button_vegetable2);
            buttonVegetable2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("vegetable2", ingredientValues.get("vegetable2") + 1);
                    rotateImageViewer.setImage(R.drawable.image_vegetable2);
                }
            });

        }

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