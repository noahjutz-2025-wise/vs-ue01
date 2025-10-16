public class Auto extends Thread {
    private final Parkhaus p;

    public Auto(Parkhaus p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            // TODO sleep, park, unpark
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
