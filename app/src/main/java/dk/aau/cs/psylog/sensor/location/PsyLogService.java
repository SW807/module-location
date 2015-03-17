package dk.aau.cs.psylog.sensor.location;

import dk.aau.cs.psylog.module_lib.SensorService;


public class PsyLogService extends SensorService {
    @Override
    public void setSensor() {
        sensor = new LocationSensorListener(this,1000,0);
    }
}
