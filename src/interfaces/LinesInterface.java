package interfaces;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;

import java.util.List;

public interface LinesInterface {
    void updateReachable(List<LineName> names, StopName stop, Time time);

    StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time);

    void clean();
}
