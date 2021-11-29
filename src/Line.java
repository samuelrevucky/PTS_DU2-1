import java.util.ArrayList;

public class Line {
    private LineName name;
    private ArrayList<Time> startingTimes;      // SORTED!
    private StopName firstStop;

    public Line(LineName lineName) {
        name = lineName;
    }

    public void updateReachable(Time time, StopName stop) {

    }

    public void updateCapacityAndGetPreviousStop(StopName stop, Time time) {

    }

}
