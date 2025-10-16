import java.util.Random;

public class Auto extends Thread {
    private final Random random = new Random();
    private final Parkhaus p;

    public Auto(Parkhaus p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(10 * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            park();
            unpark();
        }
    }

    private void park() {
        synchronized (p) {
            while (p.getLoad() >= Parkhaus.CAPACITY) {
                try {
                    p.wait();
                } catch (InterruptedException e) {
                }
            }

            p.inc();
        }
    }

    private void unpark() {
        synchronized (p) {
            p.dec();
        }
    }
}
