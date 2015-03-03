package dk.aau.cs.psylog.psylog_locationmodule;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import dk.aau.cs.psylog.module_lib.SuperService;


public class Service extends SuperService {
    @Override
    public void setSensor() {
        sensor = new LocationSensorListener(this,1000,0);
    }
}
