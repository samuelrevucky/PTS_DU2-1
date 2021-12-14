package main;

import datatypes.ConnectionData;
import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import tuples.Pair;

import java.util.List;
import java.util.Optional;

public class ConnectionSearch {
    private final Lines lines;
    private final Stops stops;

    public ConnectionSearch(Lines lines, Stops stops) {
        this.lines = lines;
        this.stops = stops;
    }

    public Optional<ConnectionData> search(StopName from, StopName to, Time time) {
        stops.setStartingStop(from, time);
        List<LineName> linesFrom = stops.getLines(from);
        lines.updateReachable(linesFrom, from, time);
        Optional<Pair<StopName, Time>> earliestReachableAfter = stops.earliestReachableStopAfter(time);

        if (earliestReachableAfter.isEmpty()) {
            // TODO: Add message no path found
            return Optional.empty();
        }

        while (earliestReachableAfter.isPresent() && earliestReachableAfter.get().getFirst() != to) {
            StopName todoStop = earliestReachableAfter.get().getFirst();
            Time todoTime = earliestReachableAfter.get().getSecond();
            linesFrom = stops.getLines(todoStop);
            lines.updateReachable(linesFrom, todoStop, todoTime);
            earliestReachableAfter = stops.earliestReachableStopAfter(todoTime);
        }

        if (earliestReachableAfter.isEmpty()) {
            // TODO: Add message
            return Optional.empty();
        }

        StopName currentStop = to;
        Time currentTime;
        LineName line;

        while (currentStop != from) {
            Pair<Time, LineName> TODO = stops.getReachableAt(currentStop);
            currentTime = TODO.getFirst();
            line = TODO.getSecond();
            if (currentTime == null || line == null) break;
            currentStop = lines.updateCapacityAndGetPreviousStop(line, currentStop, currentTime);
        }

        stops.clean();
        lines.clean();

        return Optional.of(new ConnectionData(from, to, time, new Time(2)));
    }
}
