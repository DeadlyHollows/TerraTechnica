package com.example.directioner.terratechnica.NavDrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.R;

import java.util.List;

/**
 * Created by Directioner on 2/11/2017.
 */

public class FAQAdapter extends ArrayAdapter<FAQ> {

    private Context context;
    private List<FAQ> faqData;

    private TextView ques;
    private TextView ans;

    public FAQAdapter(Context context, int resource, List<FAQ> objects) {
        super(context, resource, objects);

        this.context = context;
        faqData = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FAQ data = faqData.get(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.faq_cardview, parent, false);

            FontChangeCrawler fontChanger = new FontChangeCrawler(context.getAssets(), "Raleway-Regular.ttf");
            fontChanger.replaceFonts((ViewGroup)convertView);
        }

        ques = (TextView) convertView.findViewById(R.id.ques);
        ans = (TextView) convertView.findViewById(R.id.ans);

        String question = data.getQues();
        String answer = data.getAns();

        ques.setText(question);
        ans.setText(answer);

        return convertView;
    }
}