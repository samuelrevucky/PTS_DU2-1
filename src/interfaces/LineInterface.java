package interfaces;

import datatypes.StopName;
import datatypes.Time;

public interface LineInterface {
    void updateReachable(Time time, StopName name);

    StopName updateCapacityAndGetPreviousStop(StopName stop, Time time);
}
