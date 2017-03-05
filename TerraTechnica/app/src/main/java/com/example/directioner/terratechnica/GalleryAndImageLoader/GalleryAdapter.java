package com.example.directioner.terratechnica.GalleryAndImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.directioner.terratechnica.AppDataManager.HttpManager;
import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.GlobalData;
import com.example.directioner.terratechnica.R;

import java.util.List;

/**
 * Created by Directioner on 2/20/2017.
 */

// This ArrayAdapter takes the name of the image to download!

public class GalleryAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> imageList;
    private int size, total;

    private ImageView img, img1, img2;

    public GalleryAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);

        this.context = context;
        imageList = objects;

        size = total = imageList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (size > 0) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.gallery, parent, false);

                FontChangeCrawler fontChanger = new FontChangeCrawler(context.getAssets(), "Raleway-Regular.ttf");
                fontChanger.replaceFonts((ViewGroup)convertView);
            }

            img1 = (ImageView) convertView.findViewById(R.id.gal_img1);
            img2 = (ImageView) convertView.findViewById(R.id.gal_img2);

            img = img1;

            img.setImageResource(R.drawable.foody);
            if(isOnline()) {
                new ImageAsyncLoader().execute(GlobalData.SERVER_ADDR + "images/" + imageList.get(total - size));
            }
            size--;

            if (size > 0) {
                img = img2;

                img.setImageResource(R.drawable.foody);
                if(isOnline()) {
                    new ImageAsyncLoader().execute(GlobalData.SERVER_ADDR + "images/" + imageList.get(total - size));
                }
                size--;
            }

        }

        return convertView;
    }

    public boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if(netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        else {
            return false;
        }
    }

    private class ImageAsyncLoader extends AsyncTask<String, String, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            return HttpManager.getImage(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            img.setImageBitmap(bitmap);
            Toast.makeText(context, "Image Loaded!", Toast.LENGTH_SHORT).show();
        }
    }

}