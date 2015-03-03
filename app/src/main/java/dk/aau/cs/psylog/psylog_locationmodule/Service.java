package dk.aau.cs.psylog.psylog_locationmodule;

import dk.aau.cs.psylog.module_lib.SuperService;


public class Service extends SuperService {
    @Override
    public void setSensor() {
        sensor = new LocationSensorListener(this,1000,0);
    }
}
