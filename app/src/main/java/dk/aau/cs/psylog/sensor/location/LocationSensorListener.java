package dk.aau.cs.psylog.sensor.location;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import dk.aau.cs.psylog.module_lib.DBAccessContract;
import dk.aau.cs.psylog.module_lib.ISensor;

public class LocationSensorListener implements android.location.LocationListener, ISensor {
    private LocationManager manager;

    private long updateTimeInterval;
    private float updateDistanceChange;

    ContentResolver resolver;

    public LocationSensorListener(Context context, long updateTimeInterval, float updateDistanceChange)
    {
        manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.updateTimeInterval = updateTimeInterval;
        this.updateDistanceChange = updateDistanceChange;
        // http://developer.android.com/guide/topics/location/strategies.html

        resolver = context.getContentResolver();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Uri uri = Uri.parse(DBAccessContract.DBACCESS_CONTENTPROVIDER + "location");
            ContentValues values = new ContentValues();
            values.put("source", location.getProvider());
            values.put("latitude",location.getLatitude());
            values.put("longitude", location.getLongitude());
            values.put("accuracy", location.getAccuracy());
            values.put("altitude", location.getAltitude());
            values.put("speed", location.getSpeed());
            resolver.insert(uri, values);
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
