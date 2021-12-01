import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;
import interfaces.StopsInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stops implements StopsInterface {
    HashMap<StopName, Stop> stops;

    public Stops(HashMap<StopName, Stop> stops) {
        this.stops = stops;
    }

    @Override
    public Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time) {
        return Optional.empty();
    }

    @Override
    public void setStartingStop(StopName name, Time time) {
        stops.get(name).updateReachableAt(time, Optional.empty());
    }

    @Override
    public ArrayList<LineName> getLines(StopName name) {
        return stops.get(name).getLines();
    }

    @Override
    public HashMap<Time, LineName> getReachableAt(StopName stop) {
        return null;
    }
}
