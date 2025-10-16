import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Simulation {
    final static int N_AUTOS = 20;
    private final Random random = new Random();
    private final Parkhaus p = new Parkhaus();
    private final List<Auto> autos = IntStream.range(0, N_AUTOS).mapToObj(Auto::new).toList();

    void start() {
        for (var auto : autos) {
            var t = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(random.nextInt(10 * 1000));
                    } catch (InterruptedException e) {
                    }
                    p.park(auto);
                    p.unpark(auto);
                }
            });
            t.setDaemon(true);
            t.start();
        }

        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
