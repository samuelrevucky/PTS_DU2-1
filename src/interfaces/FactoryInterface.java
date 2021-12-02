package interfaces;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;

import java.util.List;
import java.util.Optional;

public interface FactoryInterface {

    void setStops(StopsInterface stops);

    Optional<StopInterface> createStop(StopName stopName);

    Optional<LineInterface> createLine(LineName lineName, Time time);

    void updateCapacity(List<LineSegmentInterface> lineSegments);

}
