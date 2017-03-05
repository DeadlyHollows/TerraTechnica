package com.example.directioner.terratechnica.Sponsors;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Directioner on 1/28/2017.
 */

public class Sponsors extends ListFragment {


    // A dummy list of Sponsor's!
    private List<SponsorData> sponsorData = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setData();

//        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

        setListAdapter(new MaterialSponsorAdapter(getActivity(), R.layout.sponsor_list, sponsorData));
        getActivity().findViewById(android.R.id.content).setBackgroundDrawable(getResources().getDrawable(R.drawable.bg3));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setData() {

        sponsorData.add(new SponsorData("Google", "Major Sponsor", "google"));

        sponsorData.add(new SponsorData("Directi", "Major Sponsor", "directi"));

        sponsorData.add(new SponsorData("Amazon", "Major Sponsor", "amazon"));

        sponsorData.add(new SponsorData("Facebook", "In Association with", "facebook"));

        sponsorData.add(new SponsorData("Microsoft", "In Association with", "microsoft"));

        sponsorData.add(new SponsorData("Cisco", "In Association with", "cisco"));

        sponsorData.add(new SponsorData("Radio Mirchi", "Music Partner", "radio_mirchi"));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // TODO: 1/28/2017  Open the webpage related to the sponsors!

        Toast.makeText(getActivity(), sponsorData.get(position).getSpName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.getView());
    }
}