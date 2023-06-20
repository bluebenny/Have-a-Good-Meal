package com.example.haveagoodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class OnGameActivity extends AppCompatActivity {

    class RotateImageViewer {

        // 순환 ImageView에 각각 적용될 이미지 리소스의 id 배열
        int[] ids = new int[20];

        // 순환되는 ImageView의 배열
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

        // 레이어 ImageView의 배열
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

        // 순환 이미지 뷰
        public void setImage(int id) {
            // 20개의 id를 지정
            for (int i = 19; i > 0; i--)
                ids[i] = ids[i - 1];
            ids[0] = id;

            // 지정된 id 배열을 이용에 각 ImageView에 이미지를 지정
            for (int i = 0; i < 20; i++)
                images[i].setImageResource(ids[i]);
        }

        // 순환 이미지 뷰 + 레이어 이미지 뷰
        public void setImage(int id, String layerType) {
            setImage(id); // 추가된 이미지는 순환 뷰에도 추가하여 나중에 추가한 재료가 위에 보일 수 있도록 하였음.

            // 이미지의 유형 별로 이미지가 표시되는 레벨이 달라짐.
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

    // 재료의 개수를 나타냄
    private static final int NUM_OF_INGREDIENTS = 28;

    // 모든 재료의 이름: Map에서 문자열을 통해 데이터에 접근할 때 사용됨
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

    // 각 재료를 넣어야 하는 횟수의 정답을 나타내는 배열
    // ingredientAnswers[0]은 dummy
    // ingredeintAnswers[1]은 1스테이지의 정답을 나타냄
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
                    5, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */
            }
    };

    // 각 재료의 점수 가중치를 나타내는 배열
    // ingredientScores[0]은 dummy
    // ingredeintScores[1]은 1스테이지의 재료별 가중치를 나타냄
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
                    3000, /* salt */
                    2000, /* sugar */
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
                    1810, /* salt */
                    450, /* sugar */
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
                    10, /* meat */
                    0, /* tuna */
                    0, /* vegetable1 */
                    0, /* vegetable2 */

            }
    };

    // 현재 스테이지 정보를 숫자로 저장함
    private static int stage;
    // 현재 스테이지 정보를 나타내는 ImageView
    private ImageView stageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_game);

        // 전체화면으로 변경
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 데이터베이스 사용을 위해 SharedPreferences를 사용
        StageDB.sp = getSharedPreferences(StageDB.save, MODE_PRIVATE);
        StageDB.editor = StageDB.sp.edit();
        // ImageView에 알맞은 리소스를 세팅하기 위해 현재 스테이지 정보를 가져와서 stage 변수에 저장함
        if (StageDB.sp.getBoolean("stage2_clear", true)) stage = 3;
        else if (StageDB.sp.getBoolean("stage1_clear", true)) stage = 2;
        else stage = 1;

        // 위에서 선언한 클래스의 인스턴스 생성
        RotateImageViewer rotateImageViewer = new RotateImageViewer();

        // 플레이어가 재료별로 입력하는 횟수를 저장하는 Map 생성 및 초기화
        Map<String, Integer> ingredientValues = new HashMap<>(NUM_OF_INGREDIENTS);
        for (String str : ingredientNames)
            ingredientValues.put(str, 0);

        // 현재 스테이지의 정보를 나타내는 ImageView에 stage 정보에 따른 이미지 리소스를 세팅함
        stageInfo = findViewById(R.id.stage_info);
        if (stage == 3)
            stageInfo.setImageResource(R.drawable.stage3_info);
        if (stage == 2)
            stageInfo.setImageResource(R.drawable.stage2_info);
        if (stage == 1)
            stageInfo.setImageResource(R.drawable.stage1_info);

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
                    // 각 버튼을 클릭할 때 플레이어가 입력한 횟수를 나타내는 맵의 value 값을 1 증가
                    ingredientValues.put("salt", ingredientValues.get("salt") + 1);
                    // 클릭된 버튼에 맞는 이미지를 이미지 뷰어를 통해 보이게 함
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
                    rotateImageViewer.setImage(R.drawable.image_soysauce, "sauce");
                }
            });

            Button buttonPepperPaste = findViewById(R.id.button_pepperpaste);
            buttonPepperPaste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("pepperpaste", ingredientValues.get("pepperpaste") + 1);
                    rotateImageViewer.setImage(R.drawable.image_pepperpaste, "sauce");
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
                    rotateImageViewer.setImage(R.drawable.image_syrup, "sauce");
                }
            });

            Button buttonOligo = findViewById(R.id.button_oligo);
            buttonOligo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("oligo", ingredientValues.get("oligo") + 1);
                    rotateImageViewer.setImage(R.drawable.image_oligo, "sauce");
                }
            });

            Button buttonSesameOil = findViewById(R.id.button_sesameoil);
            buttonSesameOil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("sesameoil", ingredientValues.get("sesameoil") + 1);
                    rotateImageViewer.setImage(R.drawable.image_sesameoil, "sauce");
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
                    rotateImageViewer.setImage(R.drawable.image_mayo, "sauce");
                }
            });

            Button buttonJam = findViewById(R.id.button_jam);
            buttonJam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("jam", ingredientValues.get("jam") + 1);
                    rotateImageViewer.setImage(R.drawable.image_jam, "sauce");
                }
            });

            Button buttonCarrot = findViewById(R.id.button_carrot);
            buttonCarrot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("carrot", ingredientValues.get("carrot") + 1);
                    rotateImageViewer.setImage(R.drawable.image_carrot, "stick");
                }
            });

            Button buttonOnion = findViewById(R.id.button_onion);
            buttonOnion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("onion", ingredientValues.get("onion") + 1);
                    rotateImageViewer.setImage(R.drawable.image_onion, "stick");
                }
            });

            Button buttonGreenOnion = findViewById(R.id.button_greenonion);
            buttonGreenOnion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("greenonion", ingredientValues.get("greenonion") + 1);
                    rotateImageViewer.setImage(R.drawable.image_greenonion, "stick");
                }
            });

            Button buttonLeek = findViewById(R.id.button_leek);
            buttonLeek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("leek", ingredientValues.get("leek") + 1);
                    rotateImageViewer.setImage(R.drawable.image_leek, "stick");
                }
            });

            Button buttonTofu = findViewById(R.id.button_tofu);
            buttonTofu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("tofu", ingredientValues.get("tofu") + 1);
                    rotateImageViewer.setImage(R.drawable.image_tofu, "cubic");
                }
            });

            Button buttonCucumber = findViewById(R.id.button_cucumber);
            buttonCucumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("cucumber", ingredientValues.get("cucumber") + 1);
                    rotateImageViewer.setImage(R.drawable.image_cucumber, "circle");
                }
            });

            Button buttonTomato = findViewById(R.id.button_tomato);
            buttonTomato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("tomato", ingredientValues.get("tomato") + 1);
                    rotateImageViewer.setImage(R.drawable.image_tomato, "circle");
                }
            });

            Button buttonEgg = findViewById(R.id.button_egg);
            buttonEgg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("egg", ingredientValues.get("egg") + 1);
                    rotateImageViewer.setImage(R.drawable.image_egg, "circle");
                }
            });

            Button buttonSeaweed = findViewById(R.id.button_seaweed);
            buttonSeaweed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("seaweed", ingredientValues.get("seaweed") + 1);
                    rotateImageViewer.setImage(R.drawable.image_seaweed, "seaweed");
                }
            });

            Button buttonPotato = findViewById(R.id.button_potato);
            buttonPotato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("potato", ingredientValues.get("potato") + 1);
                    rotateImageViewer.setImage(R.drawable.image_potato, "cubic");
                }
            });

            Button buttonSweetPotato = findViewById(R.id.button_sweetpotato);
            buttonSweetPotato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("sweetpotato", ingredientValues.get("sweetpotato") + 1);
                    rotateImageViewer.setImage(R.drawable.image_sweetpotato, "cubic");
                }
            });

            Button buttonDoubanjiang = findViewById(R.id.button_doubanjiang);
            buttonDoubanjiang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("doubanjiang", ingredientValues.get("doubanjiang") + 1);
                    rotateImageViewer.setImage(R.drawable.image_doubanjiang, "sauce");
                }
            });

            Button buttonMeat = findViewById(R.id.button_meat);
            buttonMeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("meat", ingredientValues.get("meat") + 1);
                    rotateImageViewer.setImage(R.drawable.image_meat, "meat");
                }
            });

            Button buttonTuna = findViewById(R.id.button_tuna);
            buttonTuna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("tuna", ingredientValues.get("tuna") + 1);
                    rotateImageViewer.setImage(R.drawable.image_tuna, "tuna");
                }
            });

            Button buttonVegetable1 = findViewById(R.id.button_vegetable1);
            buttonVegetable1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("vegetable1", ingredientValues.get("vegetable1") + 1);
                    rotateImageViewer.setImage(R.drawable.image_vegetable1, "stick");
                }
            });

            Button buttonVegetable2 = findViewById(R.id.button_vegetable2);
            buttonVegetable2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ingredientValues.put("vegetable2", ingredientValues.get("vegetable2") + 1);
                    rotateImageViewer.setImage(R.drawable.image_vegetable2, "stick");
                }
            });

        }

        // 재료 추가를 마치고 결과 화면으로 넘어가기 위한 버튼
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 10000, temp; // 최대 점수는 10000점

                for (int i = 0; i < NUM_OF_INGREDIENTS; i++) {
                    // 각 재료에 대해 정답과 입력된 횟수를 비교하여 점수를 산출함
                    temp = ingredientValues.getOrDefault(ingredientNames[i], 0) - ingredientAnswers[stage][i];
                    if (temp < 0) temp = -temp;
                    score -= temp * ingredientScores[stage][i];
                }

                // 번들에 산출된 점수를 집어넣음
                Bundle bundle = new Bundle();
                bundle.putInt("score", score);

                // 점수 정보를 가지고 있는 번들을 포함시켜 결과 화면을 실행시킴
                Intent intent = new Intent(OnGameActivity.this, ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        // 시작 화면으로 돌아가기 위한 버튼
        Button buttonHome = (Button) findViewById(R.id.button_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnGameActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }
}