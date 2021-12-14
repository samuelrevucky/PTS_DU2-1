package main;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.FactoryInterface;
import interfaces.StopInterface;
import interfaces.StopsInterface;
import tuples.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Stops implements StopsInterface {
    private final FactoryInterface factory;
    private final Map<StopName, StopInterface> stops = new HashMap<>();

    public Stops(FactoryInterface factory) {
        this.factory = factory;
    }

    @Override
    public Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time) {
        Time earliestTime = new Time(Integer.MAX_VALUE);
        StopName earliestStop = null;

        for (StopInterface stop : stops.values()) {
            Time stopTime = stop.getReachableAt().getFirst();
            if (stopTime.getSeconds() > time.getSeconds() && stopTime.getSeconds() < earliestTime.getSeconds()) {
                earliestTime = stopTime;
                earliestStop = stop.getName();
            }
        }

        if (earliestStop == null) return Optional.empty();
        return Optional.of(new Pair<>(earliestStop, earliestTime));
    }

    @Override
    public void setStartingStop(StopName name, Time time) {
        if (!stops.containsKey(name)) getStopFromFactory(name);
        stops.get(name).updateReachableAt(time, null);
    }

    private void getStopFromFactory(StopName name) {
        if (stops.containsKey(name)) ; // TODO: Add an exception stop already in stops map
        Optional<StopInterface> stop = factory.createStop(name);
        if (stop.isEmpty()) {
            // TODO: Add an exception stop does not exist
        } else {
            stops.put(name, stop.get());
        }

    }

    @Override
    public List<LineName> getLines(StopName name) {
        if (stops.containsKey(name)) ; // TODO: Add an exception stop already in stops map
        return stops.get(name).getLines();
    }

    @Override
    public Pair<Time, LineName> getReachableAt(StopName name) {
        if (stops.containsKey(name)) ; // TODO: Add an exception name already in stops map
        return stops.get(name).getReachableAt();
    }

    @Override
    public void clean() {
        stops.clear();
    }
}
