package interfaces;

import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;
import datatypes.Tuple;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);

    Tuple<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);

    void incrementCapacity(Time startTime);
}
