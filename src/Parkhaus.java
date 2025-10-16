import java.util.LinkedList;
import java.util.Queue;

public class Parkhaus {
    final static int CAPACITY = 10;
    private Queue<Auto> autos = new LinkedList<>();

    synchronized void park(Auto auto) {
        while (autos.size() >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        autos.add(auto);
        notifyAll();
    }

    synchronized void unpark(Auto auto) {
        assert getLoad() > 0;
        while (autos.peek() != auto) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        autos.remove();
        notifyAll();
    }

    int getLoad() {
        return autos.size();
    }
}
