package main;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.FactoryInterface;
import interfaces.LinesInterface;

import java.util.HashMap;
import java.util.List;

public class Lines implements LinesInterface {
    private final HashMap<LineName, Line> lines = new HashMap<>();
    private final FactoryInterface factory;

    public Lines(FactoryInterface factory) {
        this.factory = factory;
    }

    @Override
    public void updateReachable(List<LineName> names, StopName stop, Time time) {
        for (LineName name : names) {
            lines.get(name).updateReachable(time, stop);
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) {
        return lines.get(line).updateCapacityAndGetPreviousStop(stop, time);
    }

    @Override
    public void clean() {
        lines.clear();
    }
}
