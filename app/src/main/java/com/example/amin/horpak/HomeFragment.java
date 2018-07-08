package com.example.amin.horpak;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment mMap;
    Button mBtnHear;
    String mName = "หอพักศิวกาน";
    String mTel = "02-541-7268";
    double latitude = 13.822516;
    double longitude = 100.587768;

    private GoogleMap googleMaps;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mMap = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.mapView);
        mBtnHear = (Button) view.findViewById(R.id.btn_hear);

        mBtnHear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder().target(getLocation()).zoom(17).build();
                googleMaps.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                googleMaps.clear();
                googleMaps.addMarker(new MarkerOptions()
                        .position(getLocation())
                        .title(mName)
                        .snippet(mTel)
                        .flat(true)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)));
            }
        });

        mMap.getMapAsync(this);
        // Inflate the layout for this fragment
        return view;
    }

    public LatLng getLocation() {
        LatLng myLocation = new LatLng(latitude, longitude);
        return myLocation;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        this.googleMaps = googleMap;
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(getLocation())
                .zoom(15)
                .build();

        googleMap.addMarker(new MarkerOptions()
                .position(getLocation())
                .title(mName)
                .snippet(mTel)
                .flat(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(getLocation()));
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
