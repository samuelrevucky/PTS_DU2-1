package datatypes;

public class Tuple<R, S, T> {
    R first;
    S second;
    T third;

    public Tuple(R first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
