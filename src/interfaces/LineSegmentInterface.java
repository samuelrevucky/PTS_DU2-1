package interfaces;

import datatypes.StopName;
import datatypes.Time;
import tuples.Pair;
import tuples.Triplet;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);

    Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);

    void incrementCapacity(Time startTime);
}
