package com.example.directioner.terratechnica.Organizers;

import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
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

public class Contacts extends ListFragment {


    // A dummy list of Sponsor's!
    private List<ContactsData> contactsData = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setData();

//        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

        setListAdapter(new MaterialContactsAdapter(getActivity(), R.layout.contact_list, contactsData));
        getActivity().findViewById(android.R.id.content).setBackgroundDrawable(getResources().getDrawable(R.drawable.bg3));


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setData() {

        contactsData.add(new ContactsData("Shivam Bathla", "8860032051", "shivam", "Android App Developer"));
        contactsData.add(new ContactsData("Ayush Pranav", "7289017595", "ayush", "UI Developer"));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // TODO: 1/28/2017  Open the contacts app related to the person!

        Toast.makeText(getActivity(), contactsData.get(position).getPersonName() + ": "
                + contactsData.get(position).getPersonContactNo(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + contactsData.get(position).getPersonContactNo()));
//        , Uri.parse(contactsData.get(position).getPersonContactNo()));
        startActivity(intent);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.getView());
    }
}