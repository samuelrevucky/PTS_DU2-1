package main;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import datatypes.TimeDiff;
import interfaces.LineSegmentInterface;
import interfaces.StopInterface;
import tuples.Pair;
import tuples.Triplet;

import java.util.HashMap;
import java.util.Map;

public class LineSegment implements LineSegmentInterface {
    private final TimeDiff timeToNextStop;
    private final int capacity;
    private final Map<Time, Integer> numberOfPassengers;
    private final LineName lineName;
    private final StopInterface nextStop;

    public LineSegment(
            TimeDiff timeToNextStop,
            Map<Time, Integer> numberOfPassengers,
            int capacity,
            LineName lineName,
            StopInterface nextStop
    ) {
        // TODO: Add argument exception
        this.timeToNextStop = timeToNextStop;
        this.numberOfPassengers = new HashMap<>(numberOfPassengers);
        this.capacity = capacity;
        this.lineName = lineName;
        this.nextStop = nextStop;
    }

    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        Time time = new Time(startTime.getSeconds() + timeToNextStop.getDiff());
        return new Pair<>(time, nextStop.getName());
    }

    @Override
    public Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
        // TODO: Add checks
        Time time = new Time(startTime.getSeconds() + timeToNextStop.getDiff());
        boolean hasCapacity = numberOfPassengers.get(startTime) < capacity;
        if (hasCapacity) nextStop.updateReachableAt(time, lineName);
        return new Triplet<>(time, nextStop.getName(), hasCapacity);
    }

    @Override
    public void incrementCapacity(Time startTime) {
        // TODO: Add checks
        numberOfPassengers.put(startTime, numberOfPassengers.get(startTime) + 1);
    }
}
