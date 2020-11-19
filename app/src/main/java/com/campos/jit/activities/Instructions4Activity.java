package com.campos.jit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.campos.jit.R;

public class Instructions4Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions4);

        findViewById(R.id.buttonStart2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStart2:
                saveState();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }

    private void saveState(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.context_lock_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(getString(R.string.saved_state_key), true);
        editor.apply();
    }
}