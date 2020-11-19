package com.campos.jit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.campos.jit.R;
import com.campos.jit.config.Constants;

public class IntroductionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        findViewById(R.id.buttonRecomendations).setOnClickListener(this);
        findViewById(R.id.buttonStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonRecomendations:
                this.openActivity(Instructions1Activity.class.getSimpleName());
                break;
            case R.id.buttonStart:
                this.openActivity(MainActivity.class.getSimpleName());
                break;
        }
    }

    private void openActivity(String activity){
        Intent intent = null;
        if(activity.equals(Constants.instructions1))
            intent = new Intent(this, Instructions1Activity.class);
        if(activity.equals(Constants.main)) {
            intent = new Intent(this, MainActivity.class);
            saveState();
        }
        startActivity(intent);
        finish();
    }

    private void saveState(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.context_lock_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(getString(R.string.saved_state_key), true);
        editor.apply();
    }
}