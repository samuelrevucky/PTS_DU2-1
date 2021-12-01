import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.StopInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stop implements StopInterface {
    private final StopName name;
    private final ArrayList<LineName> lines;
    private Time reachableAt;
    private Optional<LineName> reachableVia;

    public Stop(StopName name, ArrayList<LineName> lines) {
        this.name = name;
        reachableAt = new Time(Integer.MAX_VALUE);
        reachableVia = Optional.empty();
        this.lines = lines;
    }

    public StopName getName() {
        return name;
    }

    @Override
    public void updateReachableAt(Time time, Optional<LineName> line) {
        if (time.getSeconds() < reachableAt.getSeconds()) {
            reachableAt = time;
            reachableVia = line;
        }
    }

    @Override
    public HashMap<Time, LineName> getReachableAt() {
        return null;
    }

    @Override
    public ArrayList<LineName> getLines() {
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
