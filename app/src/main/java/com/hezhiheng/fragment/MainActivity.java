package com.hezhiheng.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.detail_container)
    FrameLayout detail_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_android, R.id.btn_java})
    public void btnOnClick(Button button) {
        replaceDetailFragment(createFragment(button));
    }

    private Fragment createFragment(Button button) {
        DetailFragment fragment = null;
        switch (button.getId()){
            case R.id.btn_android:
                fragment = new DetailFragment(ButtonsFragment.BUTTON_ANDROID);
                break;
            case R.id.btn_java:
                fragment= new DetailFragment(ButtonsFragment.BUTTON_JAVA);
            default:
                break;
        }
        return fragment;
    }

    private void replaceDetailFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(detail_container.getId(), fragment).addToBackStack(null).commit();
    }
}