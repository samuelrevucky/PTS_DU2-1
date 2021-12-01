import datatypes.ConnectionData;
import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.LinesInterface;

import java.util.ArrayList;

public class ConnectionSearch {
    private final Lines lines;
    private final Stops stops;

    public ConnectionSearch(Lines lines, Stops stops) {
        this.lines = lines;
        this.stops = stops;
    }

    public ConnectionData search(StopName from, StopName to, Time time) {
        stops.setStartingStop(from, time);
        ArrayList<LineName> linesFrom = stops.getLines(from);

        lines.updateReachable(linesFrom, from, time);

        stops.earliestReachableStopAfter(time);
        return null;
    }
}
