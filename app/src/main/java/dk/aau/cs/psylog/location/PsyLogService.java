package dk.aau.cs.psylog.location;

import dk.aau.cs.psylog.module_lib.SuperService;


public class PsyLogService extends SuperService {
    @Override
    public void setSensor() {
        sensor = new LocationSensorListener(this,1000,0);
    }
}
