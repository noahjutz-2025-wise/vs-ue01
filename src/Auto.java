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
        // TODO synchronized p.inc()
    }

    private void unpark() {
        // TODO synchronized p.dec()
    }
}
