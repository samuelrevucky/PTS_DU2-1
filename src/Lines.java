import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.LinesInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class Lines implements LinesInterface {
    HashMap<LineName, Line> lines;

    public Lines(HashMap<LineName, Line> lines) {
        this.lines = lines;
    }

    @Override
    public void updateReachable(ArrayList<LineName> names, StopName stop, Time time) {
        for (LineName name : names) {
            lines.get(name).updateReachable(time, stop);
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) {
        return null;
    }

    @Override
    public void clean() {
        // TODO: Implement clean method
    }
}
