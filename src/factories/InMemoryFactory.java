package factories;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.FactoryInterface;
import interfaces.LineInterface;
import interfaces.LineSegmentInterface;
import interfaces.StopInterface;
import main.Stop;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryFactory implements FactoryInterface {
    private final Map<StopName, List<LineName>> stopLines;
//    private final Map<LineName, Pair<List<Time>, StopName>> lines;
//    private final Map<LineName, Pair<StopName, >> lineSegments;

    public InMemoryFactory(Map<StopName, List<LineName>> stopLines) {
        this.stopLines = stopLines;
    }

    @Override
    public Optional<StopInterface> createStop(StopName stopName) {
        if (!stopLines.containsKey(stopName)) return Optional.empty();
        return Optional.of(new Stop(stopName, stopLines.get(stopName)));
    }

    @Override
    public Optional<LineInterface> createLine(LineName lineName, Time time) {
        return Optional.empty();
    }

    @Override
    public void updateCapacity(List<LineSegmentInterface> lineSegments) {

    }
}
