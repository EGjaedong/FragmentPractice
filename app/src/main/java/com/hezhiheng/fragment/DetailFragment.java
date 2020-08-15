package com.hezhiheng.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {
    @BindString(R.string.android_detail_text)
    String androidDetailText;
    @BindString(R.string.android_detail_title)
    String androidDetailTitle;
    @BindString(R.string.java_detail_text)
    String javaDetailText;

    @BindView(R.id.detail_title)
    Button detailTitle;
    @BindView(R.id.detail_text)
    Button detailText;

    private int textType;

    public DetailFragment(int textType) {
        this.textType = textType;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setText();
    }

    public void setText() {
        switch (textType) {
            case ButtonsFragment.BUTTON_ANDROID:
                detailTitle.setText(androidDetailTitle);
                detailText.setText(androidDetailText);
                break;
            case ButtonsFragment.BUTTON_JAVA:
                detailTitle.setVisibility(View.INVISIBLE);
                detailText.setText(javaDetailText);
                break;
        }
    }
}
