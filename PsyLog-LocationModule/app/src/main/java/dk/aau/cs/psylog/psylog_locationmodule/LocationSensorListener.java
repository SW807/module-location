package dk.aau.cs.psylog.psylog_locationmodule;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class LocationSensorListener implements android.location.LocationListener {
    private LocationManager manager;


    public LocationSensorListener(Context context, long updateTimeInterval, long updateDistanceChange)
    {
        manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        // http://developer.android.com/guide/topics/location/strategies.html
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, updateTimeInterval, updateDistanceChange, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.i("Location: ", location.toString());
        }
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
