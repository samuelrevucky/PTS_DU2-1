import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stops {

    public Stops() {

    }

    public Optional<HashMap<StopName, Time>> earliestReachableStopAfter(Time time) {
        return Optional.empty();
    }

    public void setStartingStop(StopName name, Time time) {
        Stop stop = new Stop(name);
        stop.updateReachableAt(time, Optional.empty());
    }

    public ArrayList<LineName> getLines(StopName name) {
        Stop stop = new Stop(name);
        return stop.getLines();
    }

    public HashMap<Time, LineName> getReachableAt(StopName stop) {
        return null;
    }
}
