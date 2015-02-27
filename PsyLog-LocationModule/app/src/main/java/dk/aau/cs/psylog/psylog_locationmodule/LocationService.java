package dk.aau.cs.psylog.psylog_locationmodule;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import dk.aau.cs.psylog.module_lib.SuperService;


public class LocationService extends SuperService {
    @Override
    public void onCreate(){
        sensor = new LocationSensorListener(this,1337,9001);
    }
}
