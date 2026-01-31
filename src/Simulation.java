import java.util.ArrayList;

@SuppressWarnings("BusyWait")
public class Simulation {
  private final Parkhaus p = new Parkhaus();

  void start() {
    final var producer =
        new Thread(
            () -> {
              while (true) {
                final var car = new Auto(1);
                p.park(car);
                try {
                  Thread.sleep(1000);
                } catch (InterruptedException _) {
                }
              }
            });

    final var consumers = new ArrayList<Thread>();
    for (int i = 0; i < 5; i++) {
      consumers.add(
          new Thread(
              () -> {
                while (true) {
                  final var car = p.unpark();
                  try {
                    Thread.sleep(1000);
                  } catch (InterruptedException _) {
                  }
                }
              }));
    }

    producer.start();
    for (final var consumer : consumers) {
      consumer.start();
    }
  }
}
