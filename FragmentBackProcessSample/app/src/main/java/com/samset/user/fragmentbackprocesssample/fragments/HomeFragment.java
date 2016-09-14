package com.samset.user.fragmentbackprocesssample.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samset.user.fragmentbackprocesssample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private AppCompatButton btnProfile,btnDetails;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view =inflater.inflate(R.layout.fragment_home, container, false);

        btnProfile= (AppCompatButton) view.findViewById(R.id.btnprofile);
        btnDetails= (AppCompatButton) view.findViewById(R.id.btndetails);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();    //If you add tag name the you can navigate anywhere from any frgament
                transaction.replace(R.id.mainContainer,new ProfileFragment()).addToBackStack("home").commit();
            }
        });
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();    //If you add tag name the you can navigate anywhere from any frgament
                transaction.replace(R.id.mainContainer,new DetailsFragment()).addToBackStack("home").commit();
            }
        });
    }
}
