import java.util.concurrent.Semaphore;


class H2O {
    public static void main(String[] args) {
        H2O h2O = new H2O();
        int n = 5;
        new Thread(() -> {
            for (int i = 0; i < 2 * n; i++) {
                try {
                    h2O.hydrogen(() -> System.out.println("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    h2O.oxygen(() -> System.out.println("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    private
    Semaphore s1,s2,s3,s4;

    public H2O() {
        s1 = new Semaphore(2);
        s2 = new Semaphore(1);

        s3 = new Semaphore(0);
        s4 = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		s1.acquire();
        s3.release();
        s4.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire();
        s4.release();
        s3.acquire();
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
		releaseOxygen.run();
        s2.release();
    }
}