package interfaces;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import tuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface StopInterface {
    void updateReachableAt(Time time, LineName lineName);

    StopName getName();

    Pair<Time, LineName> getReachableAt();

    ArrayList<LineName> getLines();
}
