public class Parkhaus {
    private final int CAPACITY = 10;
    private int load = 0;

    void inc() {
        assert load < CAPACITY;
        load++;
    }

    void dec() {
        assert load > 0;
        load--;
    }

    int getLoad() {
        return load;
    }
}
