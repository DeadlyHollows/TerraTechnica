package com.example.directioner.terratechnica.GalleryAndImageLoader;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.GlobalData;
import com.example.directioner.terratechnica.R;

/**
 * Created by Directioner on 1/31/2017.
 */

public class Gallery extends ListFragment {

    private GridLayout container;
    private ImageView iv1, iv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GlobalData.setImageList();

        setListAdapter(new GalleryAdapter(getActivity(), R.layout.gallery, GlobalData.IMAGE_LIST));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());
    }
}