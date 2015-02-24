package dk.aau.cs.psylog.psylog_locationmodule;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class LocationService extends Service {
    private LocationSensorListener listener;
    private long updateTimeInterval, updateDistanceChange;
    private boolean isRunning = false;

    public LocationService(long updateTimeInterval, long updateDistanceChange)
    {
        this.updateTimeInterval = updateTimeInterval;
        this.updateDistanceChange = updateDistanceChange;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isRunning) {
            listener = new LocationSensorListener(this, updateTimeInterval, updateDistanceChange);
            isRunning = true;
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener.stopSensor();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
