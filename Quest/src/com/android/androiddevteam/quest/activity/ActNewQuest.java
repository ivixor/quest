package com.android.androiddevteam.quest.activity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.android.androiddevteam.quest.R;
import com.android.androiddevteam.quest.google_map.GoogleMapManager;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

/**
 * Project: Quest
 * Author: Oleksandr Priadko
 * Date: 06.07.15
 */

public class ActNewQuest extends FragmentActivity
        implements
        OnMapReadyCallback,
        View.OnClickListener{

    public static final int CONTENT_VIEW_ID = R.layout.act_new_quest;
    public static final int MAP_ID = R.id.google_map;
    public static final int MOVE_TO_CURRENT_LOC_ID = R.id.imageButton_new_quest_curr_loc;

    private GoogleMapManager googleMapManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(CONTENT_VIEW_ID);

        ((MapFragment) getFragmentManager().findFragmentById(MAP_ID)).getMapAsync(this);
        findViewById(MOVE_TO_CURRENT_LOC_ID).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMapManager = new GoogleMapManager(googleMap, this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case MOVE_TO_CURRENT_LOC_ID:
                googleMapManager.moveToMyPosition();
                break;
            default:
                break;
        }
    }
}
