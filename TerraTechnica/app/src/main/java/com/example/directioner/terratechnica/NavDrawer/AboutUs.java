package com.example.directioner.terratechnica.NavDrawer;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.directioner.terratechnica.GlobalData;
import com.example.directioner.terratechnica.R;


/**
 * Created by Directioner on 2/5/2017.
 */

public class AboutUs extends Fragment {

    private TextView aboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.about_us, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setActionBar((Toolbar) getActivity().findViewById(R.id.toolbar));

        getActivity().getActionBar().setTitle("About Us");

        aboutUs = (TextView) getActivity().findViewById(R.id.about_us);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "BreeSerif-Regular.ttf");
        aboutUs.setTypeface(type);

        aboutUs.setText(GlobalData.ABOUT_US);

    }

}