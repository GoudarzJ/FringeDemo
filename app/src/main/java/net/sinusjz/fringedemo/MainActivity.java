package net.sinusjz.fringedemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the fragments
        Fragment firstFragment = new FirstFragment();
        Fragment secondFragment = new SecondFragment();
        Fragment thirdFragment = new ThirdFragment();

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
                                .replace(R.id.frameLayout, firstFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(firstFragment);
                        break;
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                                .replace(R.id.frameLayout, secondFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(secondFragment);
                        break;
                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                                .replace(R.id.frameLayout, thirdFragment)
                                .addToBackStack(null)
                                .commit();
//                        changeFragment(thirdFragment);
                        break;
                }
                return true;
            }
        });

        // Android's built-in BottomNavigation
/*      BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        changeFragment(firstFragment);
                        break;
                    case R.id.page_2:
                        changeFragment(secondFragment);
                        break;
                }
                return true;
            }
        });*/
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