package com.samset.user.fragmentbackprocesssample.fragments;


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
public class DetailsFragment extends Fragment {

AppCompatButton compatButton,btnHome;
    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View  view =inflater.inflate(R.layout.fragment_details, container, false);

        compatButton= (AppCompatButton) view.findViewById(R.id.btnlast);
        btnHome= (AppCompatButton) view.findViewById(R.id.btnanother);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        compatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // popBackStack pops till the transaction with mentioned ‘tag’ if flag is POP_BACK_STACK_INCLUSIVE, or else 0 can be used.
                getFragmentManager().popBackStack("profile",FragmentManager.POP_BACK_STACK_INCLUSIVE);

                // popBackStackImmediate mathod work same as a popBackStack
                //getFragmentManager().popBackStackImmediate("profile",FragmentManager.POP_BACK_STACK_INCLUSIVE);

            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // popBackStack pops till the transaction with mentioned ‘tag’ if flag is POP_BACK_STACK_INCLUSIVE, or else 0 can be used.
                getFragmentManager().popBackStack("home",FragmentManager.POP_BACK_STACK_INCLUSIVE);

                // popBackStackImmediate mathod work same as a popBackStack
                //getFragmentManager().popBackStackImmediate("profile",FragmentManager.POP_BACK_STACK_INCLUSIVE);

            }
        });
    }
}
