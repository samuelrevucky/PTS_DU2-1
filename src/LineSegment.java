import datatypes.*;
import interfaces.LineSegmentInterface;

public class LineSegment implements LineSegmentInterface {
    private final TimeDiff timeToNextStop;
    private final int capacity;
    private final Pair<Time, Integer> numberOfPassengers;
    private final LineName lineName;
    private final Stop nextStop;

    public LineSegment(
            TimeDiff timeToNextStop,
            Pair<Time, Integer> numberOfPassengers,
            int capacity,
            LineName lineName,
            Stop nextStop
    ) {
        this.timeToNextStop = timeToNextStop;
        this.numberOfPassengers = numberOfPassengers;
        this.capacity = capacity;
        this.lineName = lineName;
        this.nextStop = nextStop;
    }

    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        return new Pair<>(new Time(startTime.getSeconds() + timeToNextStop.getDiff()), nextStop.getName());
    }

    @Override
    public Tuple<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
        return null;
    }

    @Override
    public void incrementCapacity(Time startTime) {

    }
}
