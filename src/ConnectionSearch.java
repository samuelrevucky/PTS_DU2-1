import java.util.ArrayList;

public class ConnectionSearch {
    private Lines lines;
    private Stops stops;

    public ConnectionSearch() {

    }

    public ConnectionData search(StopName from, StopName to, Time time) {
        stops.setStartingStop(from, time);
        ArrayList<LineName> linesTODO = stops.getLines(from);

        lines.updateReachable(linesTODO, from, time);

        stops.earliestReachableStopAfter(time);

        return null;
    }
}
