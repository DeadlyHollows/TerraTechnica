package com.example.directioner.terratechnica.Organizers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Directioner on 1/28/2017.
 */

public class MaterialContactsAdapter extends ArrayAdapter<ContactsData> {

    private Context context;
    private List<ContactsData> personList;

    public MaterialContactsAdapter(Context context, int resource, List<ContactsData> objects) {
        super(context, resource, objects);

        this.context = context;
        this.personList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        CardView cardView;
        if(convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_list, parent, false);
//            convertView.findViewById(R.id.card_view);

            FontChangeCrawler fontChanger = new FontChangeCrawler(context.getAssets(), "Raleway-Regular.ttf");
            fontChanger.replaceFonts((ViewGroup)convertView);

        }

        ContactsData personData = personList.get(position);

        ImageView personLogo = (ImageView) convertView.findViewById(R.id.person_image);
        TextView personName = (TextView) convertView.findViewById(R.id.person_name);
        TextView personSupportLevel = (TextView) convertView.findViewById(R.id.person_support_level);

        personName.setText(personData.getPersonName());
        personSupportLevel.setText(personData.getPersonSupportLevel());


        // TODO: Store the logo for sponsors in the assets directory!

        // TODO: Ensure all the logo's have .png extension!

        // Get the image resource from them assets!

        // TODO: Just a dummy image set rn! Change that later!



        InputStream stream = null;
        try {
            stream = context.getAssets().open(personData.getPersonImage() + ".png");
//            stream = context.getAssets().open("foody" + ".png");
            Drawable drawable = Drawable.createFromStream(stream, null);
            personLogo.setImageDrawable(drawable);
        } catch (IOException e) {
            Toast.makeText(context, "Image Not Loaded!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


//        int res = context.getResources().getIdentifier("foody", "drawable", context.getPackageName());
//
//        sponsorLogo.setImageResource(res);

//        sponsorLogo.setImageResource(R.drawable.foody);


        return convertView;
    }
}