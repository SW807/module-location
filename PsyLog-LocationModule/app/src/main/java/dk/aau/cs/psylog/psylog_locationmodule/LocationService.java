package dk.aau.cs.psylog.psylog_locationmodule;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class LocationService extends Service {
    private LocationSensorListener listener;
    private boolean isRunning = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isRunning) {
            listener = new LocationSensorListener(this, intent.getLongExtra("updateTimeInterval", 0), intent.getFloatExtra("updateDistanceChange", 0));
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
