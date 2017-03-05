package com.example.directioner.terratechnica.Maps;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import com.example.directioner.terratechnica.FontChangeCrawler;
import com.example.directioner.terratechnica.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by Directioner on 2/13/2017.
 */


public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Raleway-Regular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng nitDelhi = new LatLng(28.8430227d, 77.1051845d);
        CameraPosition target = CameraPosition.builder().target(nitDelhi).zoom(17.6f).bearing(70.0f)
                .tilt(BitmapDescriptorFactory.HUE_ORANGE).build();
        this.mMap.addMarker(new MarkerOptions().position(nitDelhi)
                .title("National Institute of Technology, New Delhi").snippet("Terra Technica'17")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.nitmarker)))
                .showInfoWindow();

        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842693d, 77.105865d))
                .title("IAMR Hostel")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.commercialplaces)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842971d, 77.10401d))
                .title("Girls Hostel").icon(BitmapDescriptorFactory.fromResource(R.drawable.hotels)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.84288d, 77.10485d)).title("Library")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.magazines)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842859d, 77.104893d)).title("Computer Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.computers)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842252d, 77.105158d)).title("Cafe")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cafe)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842581d, 77.103792d)).title("BasketBall Court")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sports)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842409d, 77.105404d)).title("Parking")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.automotive)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.843755d, 77.106214d)).title("Guest House")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.government)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.843233d, 77.105366d)).title("Main Stage")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.concerts)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842334d, 77.104082d)).title("VolleyBall Court")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.playgrounds)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.842604d, 77.104362d)).title("Academic Block")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.schools)));
        this.mMap.addMarker(new MarkerOptions().position(new LatLng(28.843362d, 77.105213d)).title("Auditorium")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.event)));
//        this.mMap.setInfoWindowAdapter(new C05861());
        this.mMap.addPolyline(new PolylineOptions().geodesic(true).add(new LatLng(28.841669d, 77.103909d))
                .add(new LatLng(28.843347d, 77.103217d)).add(new LatLng(28.844424d, 77.106512d))
                .add(new LatLng(28.842789d, 77.107219d)).add(new LatLng(28.841669d, 77.103909d))
                .color(R.color.colorPrimary));
        this.mMap.addPolyline(new PolylineOptions().geodesic(true).add(new LatLng(28.842884d, 77.104147d))
                .add(new LatLng(28.842788d, 77.104222d)).add(new LatLng(28.842628d, 77.104598d))
                .add(new LatLng(28.842626d, 77.104737d)).add(new LatLng(28.842689d, 77.105008d))
                .add(new LatLng(28.84259d, 77.105038d)).add(new LatLng(28.842531d, 77.104826d))
                .add(new LatLng(28.842498d, 77.104829d)).add(new LatLng(28.842479d, 77.104655d))
                .add(new LatLng(28.842505d, 77.10444d)).add(new LatLng(28.842618d, 77.104177d))
                .add(new LatLng(28.842797d, 77.104008d)).add(new LatLng(28.842884d, 77.104147d))
                .color(R.color.colorPrimary));
        this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target));

//        mMap.addMarker(new MarkerOptions().position(nitDelhi).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(nitDelhi));
    }
}