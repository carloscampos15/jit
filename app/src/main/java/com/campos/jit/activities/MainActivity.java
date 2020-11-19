package com.campos.jit.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.campos.jit.R;
import com.campos.jit.fragments.HomeFragment;
import com.campos.jit.fragments.RoutesFragment;
import com.campos.jit.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment;
    private RoutesFragment mapFragment;
    private SettingsFragment settingsFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        mapFragment = new RoutesFragment();
        settingsFragment = new SettingsFragment();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.page_map);
    }

    private void showSelectedFragment(Fragment fragment, MenuItem item, int icon){
        item.setIcon(icon);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if(fragment.equals(currentFragment))
            return;

        if(fragment.isAdded())
            fragmentTransaction.hide(currentFragment).show(fragment);
        else
        if(currentFragment != null)
            fragmentTransaction.hide(currentFragment).add(R.id.container, fragment);
        else
            fragmentTransaction.replace(R.id.container, fragment);

        fragmentTransaction.commit();
        currentFragment = fragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Menu menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.page_home).setIcon(R.drawable.ic_outline_home);
        menu.findItem(R.id.page_map).setIcon(R.drawable.ic_outline_location_on);
        menu.findItem(R.id.page_settings).setIcon(R.drawable.ic_outline_settings);
        switch (item.getItemId()) {
            case R.id.page_home:
                showSelectedFragment(homeFragment, item, R.drawable.ic_baseline_home);
                return true;
            case R.id.page_map:
                showSelectedFragment(mapFragment, item, R.drawable.ic_baseline_location_on);
                return true;
            case R.id.page_settings:
                showSelectedFragment(settingsFragment, item, R.drawable.ic_baseline_settings);
                return true;
        }
        return false;
    }
}