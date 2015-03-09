package dk.aau.cs.psylog.location;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import dk.aau.cs.psylog.module_lib.ISensor;

public class LocationSensorListener implements android.location.LocationListener, ISensor {
    private LocationManager manager;

    private long updateTimeInterval;
    private float updateDistanceChange;
    public LocationSensorListener(Context context, long updateTimeInterval, float updateDistanceChange)
    {
        Log.i("location", "Location created with time: " + updateTimeInterval + " distance: "  +updateDistanceChange);

        manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.updateTimeInterval = updateTimeInterval;
        this.updateDistanceChange = updateDistanceChange;
        // http://developer.android.com/guide/topics/location/strategies.html



    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.i("location", "time: " + updateTimeInterval + " distance: "  +updateDistanceChange + location.toString());
        }
    }

    public void startSensor(){
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, updateTimeInterval, updateDistanceChange, this);
    }

    public void stopSensor()
    {
        manager.removeUpdates(this);
    }

    public void sensorParameters(Intent intent)
    {
        updateDistanceChange = intent.getIntExtra("updateDistanceChange",0);
        updateTimeInterval =intent.getIntExtra("updateTimeInterval",0);
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
