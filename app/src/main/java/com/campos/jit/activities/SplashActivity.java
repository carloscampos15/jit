package com.campos.jit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;

import com.campos.jit.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.context_lock_preferences), Context.MODE_PRIVATE);
        boolean statePreferences = sharedPref.getBoolean(getString(R.string.saved_state_key), false);
        Intent intent = null;
        if(!statePreferences)
            intent = new Intent(this, IntroductionActivity.class);
        else
            intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}