package com.example.directioner.terratechnica;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.directioner.terratechnica.LayoutDesign.CircleMenuLayout;

/**
 * Created by Directioner on 2/8/2017.
 */

public class CircleFragment extends Fragment {

    private CircleMenuLayout mCircleMenuLayout;

    private Communicator communicator;

    private String[] mItemTexts = new String[]{
            "Events", "InstaFeed",
            "Sponsors", "Maps",
            "Contact", "Gallery",
            "Games"
    };
    private int[] mItemImgs = new int[]{
            R.drawable.calendar, R.drawable.instagram,
            R.drawable.sponsor, R.drawable.map,
            R.drawable.phone, R.drawable.gallery,
            R.drawable.controller
    };

    private ImageButton navButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main02, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.getView());

        communicator = (Communicator) getActivity();

        init();
    }

    private void init() {

        mCircleMenuLayout = (CircleMenuLayout) getActivity().findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        navButton = (ImageButton) getActivity().findViewById(R.id.nav_toggle);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicator.openNavDrawer();
            }
        });

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {

            @Override
            public void itemClick(View view, int pos) {

                Intent intent = new Intent(getActivity(), CategoryItemDisplay.class);

                intent.putExtra(CategoryItemDisplay.CATEGORY_NAME, mItemTexts[pos]);

/*                Toast.makeText(MainActivity.this, mItemTexts[pos],
                        Toast.LENGTH_SHORT).show();
*/
                startActivity(intent);
            }

            @Override
            public void itemCenterClick(View view) {
                Toast.makeText(getActivity(),
                        "NIT DELHI",
                        Toast.LENGTH_SHORT).show();

                String NitDUrl = "https://www.nitdelhi.ac.in";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(NitDUrl));

                Intent chooser = Intent.createChooser(intent, "Complete action using ...");
                startActivity(chooser);

            }
        });
    }

    public interface Communicator {
        void openNavDrawer();
    }
}
