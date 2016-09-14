package com.samset.user.fragmentbackprocesssample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.samset.user.fragmentbackprocesssample.fragments.HomeFragment;
import com.samset.user.fragmentbackprocesssample.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragTransaction(new LoginFragment());
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void fragTransaction(Fragment frag) {
        if (frag.isAdded()) {
            Log.e(TAG, " fragment add");
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.mainContainer, frag).addToBackStack(null).commit();
        } else {
            Log.e(TAG, " fragment replace");
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.mainContainer, frag).addToBackStack(null).commit();
        }
    }


    @Override
    public void onBackPressed() {

        // here you simply back handle you check stack count and then enable backpress button
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            Log.e(TAG, " fragment popback ");
        } else {
            super.onBackPressed();
        }
    }
}
