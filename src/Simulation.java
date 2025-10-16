import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Simulation {
    final static int N_AUTOS = 20;
    private final Parkhaus p = new Parkhaus();
    private final List<Auto> autos = IntStream.range(0, N_AUTOS).mapToObj(i -> {
                var a = new Auto(p, i);
                a.setDaemon(true);
                return a;
            })
            .collect(Collectors.toList());


    void start() {
        for (var auto : autos) {
            auto.start();
        }

        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
