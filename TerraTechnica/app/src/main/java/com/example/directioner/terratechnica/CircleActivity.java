package com.example.directioner.terratechnica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.directioner.terratechnica.LayoutDesign.CircleMenuLayout;
import com.example.directioner.terratechnica.LayoutDesign.CircleMenuLayout.OnMenuItemClickListener;
/**
 * <pre>
 * @author zhy
 * http://blog.csdn.net/lmj623565791/article/details/43131133
 * </pre>
 */
public class CircleActivity extends Activity {

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] {
            "Events", "InstaFeed",
            "Sponsors", "Maps",
            "Contact", "Gallery"
    };
    private int[] mItemImgs = new int[] {
        R.drawable.calendar, R.drawable.instagram,
        R.drawable.sponsor, R.drawable.map,
        R.drawable.phone, R.drawable.gallery
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main02);
//		setContentView(R.layout.activity_main);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);


        mCircleMenuLayout.setOnMenuItemClickListener(new OnMenuItemClickListener() {

            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(CircleActivity.this, mItemTexts[pos],
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void itemCenterClick(View view) {
                Toast.makeText(CircleActivity.this,
                        "NIT DELHI",
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

}