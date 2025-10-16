import java.util.LinkedList;
import java.util.Queue;

public class Parkhaus {
    final static int CAPACITY = 10;
    private Queue<Auto> autos = new LinkedList<>();

    synchronized void park(Auto auto) {
        IO.println("Parkhaus: park: (id=" + auto.id() + ", load=" + autos.size() + ")");
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
        IO.println("Parkhaus: unpark: (id=" + auto.id() + ", load=" + autos.size() + ")");
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
