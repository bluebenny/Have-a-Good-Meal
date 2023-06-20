package com.example.haveagoodmeal;

import android.content.SharedPreferences;

public class StageDB {
    public static int stage1 = 0; //stage1 클리어 여부 저장
    public static int stage2 = 0; //stage2 클리어 여부 저장
    public static int stage3 = 0; //stage3 클리어 여부 저장
    public static int stage4 = 0; //stage4 클리어 여부 저장
    public static int stage5 = 0; //stage5 클리어 여부 저장

    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;
    public static String save = "stage status";
    public static Boolean st1_clear;
    public static Boolean st2_clear;
    public static Boolean st3_clear;
    public static Boolean st4_clear;
}