package dk.aau.cs.psylog.psylog_locationmodule;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class LocationService extends Service {
    private LocationSensorListener listener;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        listener.startSensor();

        return START_STICKY;
    }

    @Override
    public void onCreate(){
        listener = new LocationSensorListener(this,1337,9001);
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
