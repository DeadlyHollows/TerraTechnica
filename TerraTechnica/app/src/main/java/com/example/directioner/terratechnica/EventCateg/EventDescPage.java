package com.example.directioner.terratechnica.EventCateg;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.GlobalData;
import com.example.directioner.terratechnica.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Directioner on 2/12/2017.
 */

public class EventDescPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.event_desc, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup) this.getView());

        // TODO: Remove these unnecessary default value of "" and "" after testing the app!

        Bundle bundle = getArguments();

        String eventCateg = bundle.getString(GlobalData.EVENT_CATEG, "");
        String eventName = bundle.getString(GlobalData.EVENT_NAME, "");

        setEventImage();

        List<EventDetails> details = null;

        details = EventsDataManager.dataFetch(eventCateg);
        switch (eventCateg) {
            case "code":
                Toast.makeText(getActivity(), "CODE!", Toast.LENGTH_SHORT).show();
                break;
            case "bot":
                Toast.makeText(getActivity(), "BOT!", Toast.LENGTH_SHORT).show();
                details = EventsDataManager.botDataManager;
                break;
            case "workshop":
                Toast.makeText(getActivity(), "WORKSHOP!", Toast.LENGTH_SHORT).show();
                details = EventsDataManager.workshopDataManager;
                break;
            case "misc":
                Toast.makeText(getActivity(), "MISC!", Toast.LENGTH_SHORT).show();
                details = EventsDataManager.miscDataManager;
                break;
        }

        EventDetails detailsInfo = null;
//        = new EventDetails("1", "2", "3", 4, "5", "6", "7", "8");

        for (EventDetails detail : details) {
            if (detail.getEventName().equals(eventName)) {
                detailsInfo = detail;
                break;
            }
        }

        ((TextView) getActivity().findViewById(R.id.event_name)).setText(detailsInfo.getEventName());
        ((TextView) getActivity().findViewById(R.id.intro)).setText(detailsInfo.getEventIntro());
        ((TextView) getActivity().findViewById(R.id.desc)).setText(detailsInfo.getEventDesc());
        ((TextView) getActivity().findViewById(R.id.rules)).setText(detailsInfo.getEventRules());

        super.onActivityCreated(savedInstanceState);
    }

    private void setEventImage() {
        Drawable drawable;
        InputStream stream = null;

        try {
            stream = getActivity().getAssets().open("foody" + ".png");
//            stream = getActivity().getAssets().open(detailsInfo.getEventImage() + ".png");
            drawable = Drawable.createFromStream(stream, null);
            ((ImageView) getActivity().findViewById(R.id.event_image)).setImageDrawable(drawable);
            Toast.makeText(getActivity(), "DISPLAYING FOODY!", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            Toast.makeText(getActivity(), "ERROR DISPLAYING FOODY!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        } finally {

            try {
                // TODO: Close the input stream wherever you have opened it to get the assets!
                stream.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
    }
}
