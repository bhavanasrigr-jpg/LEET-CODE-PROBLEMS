import java.util.function.IntConsumer;
import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;
    private int current = 1;
    
    private Semaphore numberSem = new Semaphore(1);
    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzbuzzSem = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz"
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            fizzSem.acquire();
            if (current > n) { release(); return; }
            printFizz.run();
            current++;
            release();
        }
    }

    // printBuzz.run() outputs "buzz"
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            buzzSem.acquire();
            if (current > n) { release(); return; }
            printBuzz.run();
            current++;
            release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz"
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            fizzbuzzSem.acquire();
            if (current > n) { release(); return; }
            printFizzBuzz.run();
            current++;
            release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            numberSem.acquire();
            if (current > n) { release(); return; }
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
            }
            release();
        }
    }
    
    private void release() {
        if (current > n) {
            // Wake everyone up so they can exit their loops
            numberSem.release();
            fizzSem.release();
            buzzSem.release();
            fizzbuzzSem.release();
            return;
        }
        if (current % 15 == 0) {
            fizzbuzzSem.release();
        } else if (current % 3 == 0) {
            fizzSem.release();
        } else if (current % 5 == 0) {
            buzzSem.release();
        } else {
            numberSem.release();
        }
    }
}
