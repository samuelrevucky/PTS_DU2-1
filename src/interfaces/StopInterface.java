package interfaces;

import datatypes.LineName;
import datatypes.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface StopInterface {
    void updateReachableAt(Time time, Optional<LineName> line);

    HashMap<Time, LineName> getReachableAt();

    ArrayList<LineName> getLines();
}
