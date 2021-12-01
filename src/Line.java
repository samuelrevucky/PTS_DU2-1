import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.LineInterface;

import java.util.ArrayList;

public class Line implements LineInterface {
    private final LineName name;
    private final ArrayList<Time> startingTimes;      // SORTED!
    private final StopName firstStop;
    private final ArrayList<LineSegment> lineSegments;

    public Line(LineName name, ArrayList<Time> startingTimes, StopName firstStop, ArrayList<LineSegment> lineSegments) {
        this.name = name;
        this.startingTimes = startingTimes;
        this.firstStop = firstStop;
        this.lineSegments = lineSegments;
    }

    @Override
    public void updateReachable(Time time, StopName name) {
        if (name == firstStop) {

        }
    }

    @Override
    public void updateCapacityAndGetPreviousStop(StopName stop, Time time) {

    }

}
