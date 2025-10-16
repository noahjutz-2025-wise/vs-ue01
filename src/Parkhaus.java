import java.util.LinkedList;
import java.util.Queue;

public class Parkhaus {
    final static int CAPACITY = 10;
    private Queue<Auto> autos = new LinkedList<>();

    void park(Auto auto) {
        assert getLoad() < CAPACITY;
        autos.add(auto);
    }

    void unpark() {
        assert getLoad() > 0;
        autos.remove();
    }

    Auto get() {
        return autos.peek();
    }

    int getLoad() {
        return autos.size();
    }
}
