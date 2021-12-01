package interfaces;

import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface StopsInterface {
    Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time);

    void setStartingStop(StopName name, Time time);

    ArrayList<LineName> getLines(StopName name);

    HashMap<Time, LineName> getReachableAt(StopName stop);
}
