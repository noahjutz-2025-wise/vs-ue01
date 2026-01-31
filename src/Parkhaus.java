import java.util.LinkedList;
import java.util.Queue;

public class Parkhaus {
  static final int CAPACITY = 10;
  private Queue<Auto> cars = new LinkedList<>();

  synchronized void park(Auto car) {
    IO.println("Parkhaus: park: (id=" + car.id() + ", load=" + cars.size() + ")");
    while (cars.size() >= CAPACITY) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    cars.add(car);
    notifyAll();
  }

  synchronized Auto unpark() {
    while (cars.isEmpty()) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    final var car = cars.remove();
    IO.println("Parkhaus: unpark: (id=" + car.id() + ", load=" + cars.size() + ")");
    notifyAll();
    return car;
  }
}
