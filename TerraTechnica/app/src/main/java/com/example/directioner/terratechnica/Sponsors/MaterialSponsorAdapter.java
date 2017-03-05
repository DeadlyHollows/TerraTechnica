package com.example.directioner.terratechnica.Sponsors;

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

public class MaterialSponsorAdapter extends ArrayAdapter<SponsorData> {

    private Context context;
    private List<SponsorData> spList;

    public MaterialSponsorAdapter(Context context, int resource, List<SponsorData> objects) {
        super(context, resource, objects);

        this.context = context;
        this.spList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sponsor_list, parent, false);

            FontChangeCrawler fontChanger = new FontChangeCrawler(context.getAssets(), "Raleway-Regular.ttf");
            fontChanger.replaceFonts((ViewGroup)convertView);
        }

        SponsorData spData = spList.get(position);

        ImageView sponsorLogo = (ImageView) convertView.findViewById(R.id.sponsor_logo);
        TextView sponsorName = (TextView) convertView.findViewById(R.id.person_name);
        TextView sponsorSupportLevel = (TextView) convertView.findViewById(R.id.sponsor_support_level);

        sponsorName.setText(spData.getSpName());
        sponsorSupportLevel.setText(spData.getSpCateg());


        // TODO: Store the logo for sponsors in the assets directory!

        // TODO: Ensure all the logo's have .png extension!

        // Get the image resource from them assets!

        // TODO: Just a dummy image set rn! Change that later!

//            InputStream stream = context.getAssets().open(spData.getSpLogo() + ".png");


        InputStream stream = null;
        try {
            stream = context.getAssets().open("foody" + ".png");
            Drawable drawable = Drawable.createFromStream(stream, null);
            sponsorLogo.setImageDrawable(drawable);
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