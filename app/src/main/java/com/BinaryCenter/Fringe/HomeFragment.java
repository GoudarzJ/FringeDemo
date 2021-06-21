package com.BinaryCenter.Fringe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    ImageView lamp;
    AlphaAnimation animation;
    MaterialButton animationFragmentButton;
    Fragment animationFragment = new AnimationFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Slide bed
        ImageView bed = view.findViewById(R.id.img_bed);
        Animation slideAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);
        bed.startAnimation(slideAnimation);

        ImageView logo = view.findViewById(R.id.img_logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fringeinterior.com/"));
                startActivity(browserIntent);
            }
        });



        animationFragmentButton = view.findViewById(R.id.home_btn_my_projects);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);

        animationFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.addToBackStack(null);
                transaction.replace(R.id.frameLayout, animationFragment);
                transaction.commit();
            }
        });
    }
}