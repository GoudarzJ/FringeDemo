package com.BinaryCenter.Fringe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.BinaryCenter.Fringe.Page2Fragment;
import com.BinaryCenter.Fringe.R;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment page2Fragment = new Page2Fragment();
        Fragment page3Fragment = new Page3Fragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();


        view.findViewById(R.id.project_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.setCustomAnimations(R.anim.zoom_in, R.anim.zoom_out);
                transaction.replace(R.id.frameLayout, page2Fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        view.findViewById(R.id.project_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                transaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
                transaction.addToBackStack(null);
                transaction.replace(R.id.frameLayout, page3Fragment);
                transaction.commit();
            }
        });
    }
}