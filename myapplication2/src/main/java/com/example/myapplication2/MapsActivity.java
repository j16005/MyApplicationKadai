package com.example.myapplication2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
        //mMap.addMarker(new MarkerOptions().position(new LatLng(34.983419, 138.406868)).title("sangi"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(34.983419, 138.406868)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(34.983419, 138.406868),15));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.9834,138.4068))
                .title("ラーメン")

                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("imagesneko",150,100))));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.98,138.40))
                .title("じゃパリパーク")
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("image",150,100))));
    }
    public Bitmap resizeMapIcons(String iconName, int width , int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
