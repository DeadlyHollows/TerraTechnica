package com.example.directioner.terratechnica.EventCateg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Directioner on 2/12/2017.
 */

public class EventsAdapter extends ArrayAdapter<EventDetails> {

    private Context context;
    private List<EventDetails> eventDetails;

    public EventsAdapter(Context context, int resource, List<EventDetails> objects) {
        super(context, resource, objects);

        this.context = context;
        this.eventDetails = objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EventDetails details = eventDetails.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.event_list_cards, parent, false);

            FontChangeCrawler fontChanger = new FontChangeCrawler(context.getAssets(), "Raleway-Regular.ttf");
            fontChanger.replaceFonts((ViewGroup)convertView);
        }

        ((TextView) convertView.findViewById(R.id.event_name)).setText(details.getEventName());
        ((TextView) convertView.findViewById(R.id.event_venue)).setText(details.getVenue());
        ((TextView) convertView.findViewById(R.id.event_timing)).setText(details.getTime() + "(Day " + details.getDay() + ")");

        InputStream stream = null;

        Drawable drawable = null;

        try {

            stream = context.getAssets().open("foody" + ".png");
            drawable = Drawable.createFromStream(stream, null);
            ((ImageView) convertView.findViewById(R.id.event_image)).setImageDrawable(drawable);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return convertView;
    }
}