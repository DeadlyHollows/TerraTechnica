package com.example.directioner.terratechnica;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Directioner on 2/23/2017.
 */

public class FontChangeCrawler {

    private Typeface typeface;

    public FontChangeCrawler(Typeface typeface) {
        this.typeface = typeface;
    }

    public FontChangeCrawler(AssetManager assets, String assetsFontFileName) {
        typeface = Typeface.createFromAsset(assets, assetsFontFileName);
    }

    public void replaceFonts(ViewGroup viewTree) {
        View child;
        for(int i = 0; i < viewTree.getChildCount(); ++i) {
            child = viewTree.getChildAt(i);
            if(child instanceof ViewGroup) {
                // recursive call
                replaceFonts((ViewGroup)child);
            }
            else if(child instanceof TextView) {
                // base case
                ((TextView) child).setTypeface(typeface);
            }
            else if(child instanceof AppCompatTextView) {
                // base case
                ((AppCompatTextView) child).setTypeface(typeface);
            }
       }
    }
}