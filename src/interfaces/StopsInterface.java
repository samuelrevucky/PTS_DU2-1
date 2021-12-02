package interfaces;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import tuples.Pair;

import java.util.ArrayList;
import java.util.Optional;

public interface StopsInterface {
    Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time);

    void setStartingStop(StopName name, Time time);

    ArrayList<LineName> getLines(StopName name);

    Pair<Time, LineName> getReachableAt(StopName stop);

    void clean();
}
