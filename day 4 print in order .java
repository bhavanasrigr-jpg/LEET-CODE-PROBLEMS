import java.util.concurrent.CountDownLatch;

class Foo {

    // Step 1: Create two latches
    CountDownLatch firstDone = new CountDownLatch(1);
    CountDownLatch secondDone = new CountDownLatch(1);

    // Step 2: Constructor
    public Foo() {
    }

    // Step 3: first() method
    public void first(Runnable printFirst) throws InterruptedException {

        // Print "first"
        printFirst.run();

        // Signal that first() is finished
        firstDone.countDown();
    }

    // Step 4: second() method
    public void second(Runnable printSecond) throws InterruptedException {

        // Wait until first() finishes
        firstDone.await();

        // Print "second"
        printSecond.run();

        // Signal that second() is finished
        secondDone.countDown();
    }

    // Step 5: third() method
    public void third(Runnable printThird) throws InterruptedException {

        // Wait until second() finishes
        secondDone.await();

        // Print "third"
        printThird.run();
    }
}
