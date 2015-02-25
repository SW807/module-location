package dk.aau.cs.psylog.psylog_locationmodule;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class LocationSensorListener implements android.location.LocationListener {
    private LocationManager manager;

    private long updateTimeInterval;
    private float updateDistanceChange;
    public LocationSensorListener(Context context, long updateTimeInterval, float updateDistanceChange)
    {
        manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.updateTimeInterval = updateTimeInterval;
        this.updateDistanceChange = updateDistanceChange;
        // http://developer.android.com/guide/topics/location/strategies.html

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.i("location", location.toString());
        }
    }

    public void startSensor(){
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, updateTimeInterval, updateDistanceChange, this);
    }

    public void stopSensor()
    {
        manager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
