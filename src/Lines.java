import java.util.ArrayList;

public class Lines {

    public void updateReachable(ArrayList<LineName> lines, StopName stop, Time time) {
        for (LineName lineName : lines) {
            Line line = new Line(lineName);
            line.updateReachable(time, stop);
        }
    }

    public StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) {
        return null;
    }

    public void clean() {

    }
}
