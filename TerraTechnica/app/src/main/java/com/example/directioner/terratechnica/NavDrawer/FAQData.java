package com.example.directioner.terratechnica.NavDrawer;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.GlobalData;
import com.example.directioner.terratechnica.R;


/**
 * Created by Directioner on 2/8/2017.
 */

public class FAQData extends ListFragment {
/*
    private String faqData = "";
    private TextView dataContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;

        if (isOnline()) {
            view = inflater.inflate(R.layout.faq_data, container, false);
        } else {
            Toast.makeText(getActivity(), "Offline!", Toast.LENGTH_SHORT).show();
            view = super.onCreateView(inflater, container, savedInstanceState);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataContainer = (TextView) getActivity().findViewById(R.id.faqDataContainer);

        if (dataContainer != null) {
            DataManager manager = new DataManager();
            manager.execute(GlobalData.SERVER_ADDR + GlobalData.FAQ);


            JSONArray dataArray = null;
            try {
//                Toast.makeText(getActivity(), "HEY!", Toast.LENGTH_SHORT).show();
                JSONObject dataObject = new JSONObject(faqData);
                dataArray = dataObject.getJSONArray("faq");
//                Toast.makeText(getActivity(), "YO!", Toast.LENGTH_SHORT).show();
                for(int i=0;i<dataArray.length();i++) {
                    JSONObject obj = dataArray.getJSONObject(i);
                    Toast.makeText(getActivity(), obj.getString("quiz"), Toast.LENGTH_LONG).show();
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "O! MAN!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    private class DataManager extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            return HttpManager.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            faqData = s;
            dataContainer.setText(s);
        }
    }

*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GlobalData.setFAQData();

        setListAdapter(new FAQAdapter(getActivity(), R.layout.faq_cardview, GlobalData.FAQ_DATA));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getActivity().getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.getView());
    }
}