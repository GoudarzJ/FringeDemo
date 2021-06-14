package com.BinaryCenter.Fringe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;

import com.BinaryCenter.Fringe.FirstFragment;
import com.BinaryCenter.Fringe.R;

public class AnimationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment homeFragment = new FirstFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_reverse, R.anim.slide_out_reverse);

        ImageView lamp = view.findViewById(R.id.lamp);

        // Alpha Animation
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
//        alphaAnimation.setStartOffset(300);
        alphaAnimation.setFillAfter(true);
        view.findViewById(R.id.anim_btn_alpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamp.startAnimation(alphaAnimation);
            }
        });

        // Rotate Animation
        RotateAnimation rotateAnimation = new RotateAnimation(180f, 360f, 15f, 15f);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setDuration(700);
        view.findViewById(R.id.anim_btn_rotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamp.startAnimation(rotateAnimation);
            }
        });

        // Slide Animation
        Animation slideAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.object_slide_in);
        view.findViewById(R.id.anim_btn_slide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamp.startAnimation(slideAnimation);
            }
        });

        // Zoom Animation
        Animation zoomAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_in);
        view.findViewById(R.id.anim_btn_zoom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamp.startAnimation(zoomAnimation);
            }
        });

        // Zoom Animation
        Animation rotateZoomAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.together);
        view.findViewById(R.id.anim_btn_rotatezoom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamp.startAnimation(rotateZoomAnimation);
            }
        });


        // Back Button
        view.findViewById(R.id.anim_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.frameLayout, homeFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}