package interfaces;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import tuples.Pair;

import java.util.List;

public interface StopInterface {
    void updateReachableAt(Time time, LineName lineName);

    StopName getName();

    Pair<Time, LineName> getReachableAt();

    List<LineName> getLines();
}
