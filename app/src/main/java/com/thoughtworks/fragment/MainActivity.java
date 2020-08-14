package com.thoughtworks.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonsFragment buttonsFragment = new ButtonsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.buttons_container, buttonsFragment).commit();
    }
}