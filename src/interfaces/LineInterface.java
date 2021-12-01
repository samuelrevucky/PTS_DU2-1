package interfaces;

import datatypes.StopName;
import datatypes.Time;

public interface LineInterface {
    void updateReachable(Time time, StopName name);

    void updateCapacityAndGetPreviousStop(StopName stop, Time time);
}
