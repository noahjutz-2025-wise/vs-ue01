import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {
    private final List<Auto> autos = new ArrayList<>(Collections.nCopies(20, new Auto()));

    void start() {
        for (var auto : autos) {
            // start auto
        }

        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
