import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final ReentrantLock[] forks = new ReentrantLock[5];
    // Only allow 4 philosophers to try picking up forks at the same time —
    // guarantees at least one can get both forks, preventing circular wait.
    private final Semaphore permits = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        permits.acquire();
        try {
            forks[left].lock();
            forks[right].lock();

            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();

        } finally {
            forks[left].unlock();
            forks[right].unlock();
            permits.release();
        }
    }
}
