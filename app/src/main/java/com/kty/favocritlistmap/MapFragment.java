package com.kty.favocritlistmap;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback{
    private MapView mapView = null;
    public String fName;
    public Double x,y;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }
    @Nullable
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//액티비티가 처음 생성될 때 실행되는 함수

        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        Bundle bundle = getArguments();
        if(!(bundle==null)){

            fName=bundle.getString("Name");
            x=bundle.getDouble("X");
            y=bundle.getDouble("Y");
            Log.d("x,y", "onCreateView: "+x+"  "+y);

        }else{
            fName = "기본 시작 위치";
            x = 37.54892296550104;
            y = 126.99089033876304;


        }
        mapView = (MapView)v.findViewById(R.id.map);

        mapView.getMapAsync(this);


        return v;
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("x,y", "onMapReady: "+x+"  "+y);
        LatLng STARTPOINT = new LatLng(x,y);

        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(STARTPOINT);

        markerOptions.title(fName);

        markerOptions.snippet(fName);

        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(STARTPOINT));

        googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
    }
}