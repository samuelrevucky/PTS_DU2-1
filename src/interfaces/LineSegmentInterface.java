package interfaces;

import datatypes.StopName;
import datatypes.Time;
import tuples.Pair;
import tuples.Triple;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);

    Triple<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);

    void incrementCapacity(Time startTime);
}
