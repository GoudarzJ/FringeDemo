package com.BinaryCenter.Fringe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);

        // Initialize the fragments
        Fragment homeFragment = new HomeFragment();
        Fragment secondFragment = new SecondFragment();
        Fragment thirdFragment = new ThirdFragment();
        Fragment profileFragment = new ProfileFragment();

/*
        // Bottom Navigation
        SmoothBottomBar bottomBar = findViewById(R.id.smoothBottomBar);
        bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch (i) {
                    case 0:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                                .replace(R.id.frameLayout, homeFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(homeFragment);
                        break;
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_fast, R.anim.fade_out)
                                .replace(R.id.frameLayout, secondFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(secondFragment);
                        break;
                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_fast, R.anim.slide_out)
                                .replace(R.id.frameLayout, thirdFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(thirdFragment);
                        break;
                    case 3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_fast, R.anim.slide_out)
                                .replace(R.id.frameLayout, profileFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(thirdFragment);
                        break;
                }
                return true;
            }
        });
*/

        // Android's built-in BottomNavigation


      BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                                .replace(R.id.frameLayout, homeFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(homeFragment);
                        break;
                    case R.id.nav_projects:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_fast, R.anim.fade_out)
                                .replace(R.id.frameLayout, secondFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.nav_share:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_fast, R.anim.slide_out)
                                .replace(R.id.frameLayout, thirdFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.nav_profile:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_fast, R.anim.slide_out)
                                .replace(R.id.frameLayout, profileFragment)
                                .addToBackStack(null)
                                .commit();
                        break;

                }
                return true;
            }
        });


    }

    @Override
    protected void onResume() {
        // Hide the status bar.
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

        super.onResume();
    }

    @Override
    // Close the app when back-key pressed
    public void onBackPressed() {
        finish();
    }

/*    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }*/
}