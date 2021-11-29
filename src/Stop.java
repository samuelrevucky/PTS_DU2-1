import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stop {
    private StopName name;
    private Optional<Time> reachableAt;
    private Optional<LineName> reachableVia;
    private ArrayList<LineName> lines;

    public Stop(StopName name) {
        this.name = name;
    }

    public void updateReachableAt(Time time, Optional<LineName> line) {
        // TODO: stop changes its internal state and returns
        Time lowestTimeReachableAt =
    }

    public HashMap<Time, LineName> getReachableAt() {
        return null;
    }

    public ArrayList<LineName> getLines() {
        // TODO: GET LINES?
        return null;
    }
}
