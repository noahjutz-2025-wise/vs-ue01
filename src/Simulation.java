import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {
    final static int N_AUTOS = 20;
    private final Parkhaus p = new Parkhaus();
    private final List<Auto> autos = new ArrayList<>(Collections.nCopies(N_AUTOS, new Auto(p)));

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
