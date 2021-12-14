package factories;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.FactoryInterface;
import interfaces.LineInterface;
import interfaces.LineSegmentInterface;
import interfaces.StopInterface;

import java.util.List;
import java.util.Optional;

public class DatabaseFactory implements FactoryInterface {

    public DatabaseFactory() {

    }

    @Override
    public Optional<StopInterface> createStop(StopName stopName) {
        return Optional.empty();
    }

    @Override
    public Optional<LineInterface> createLine(LineName lineName, Time time) {
        return Optional.empty();
    }

    @Override
    public void updateCapacity(List<LineSegmentInterface> lineSegments) {

    }
}
