package main;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.StopInterface;
import tuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class Stop implements StopInterface {
    private final StopName name;
    private final List<LineName> lines;
    private Time reachableAt = new Time(Integer.MAX_VALUE);
    // TODO: Make reachableVia Optional
    private LineName reachableVia = null;

    public Stop(StopName name, List<LineName> lines) {
        this.name = name;
        this.lines = new ArrayList<>(lines);
    }

    @Override
    public StopName getName() {
        return name;
    }

    @Override
    public void updateReachableAt(Time time, LineName lineName) {
        // TODO: Add argument exception
        if (time.getSeconds() < reachableAt.getSeconds()) {
            reachableAt = time;
            reachableVia = lineName;
        }
    }

    @Override
    public Pair<Time, LineName> getReachableAt() {
        return new Pair<>(reachableAt, reachableVia);
    }

    @Override
    public List<LineName> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return name.equals(stop.name);
    }
}
