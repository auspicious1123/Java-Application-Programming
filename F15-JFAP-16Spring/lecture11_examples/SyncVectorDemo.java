import java.util.Vector;

/**
 * Example code for Vector synchronization and race condition.
 * @author Terry Lee
 */
public class SyncVectorDemo {

    /**
     * Program to demo race condition with vector and how to synchronize.
     * @param args arguments
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int numberOfIterations = 20;
        Vector<Integer> vector = new Vector<Integer>();

        Thread t1 = new Thread(new ListJob(vector, numberOfIterations));
        Thread t2 = new Thread(new ListJob(vector, numberOfIterations));

        t1.start();
        t2.start();

        // Waits for these threads to terminate before checking the list state.
        t1.join();
        t2.join();

        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("Index at " + i + ": " + vector.get(i));
        }

        System.out.println("Final size should be " + numberOfIterations
                + ", actual size: " + vector.size());
    }

    /**
     * Static nested class that implements Runnable
     * @author Terry Lee
     */
    private static class ListJob implements Runnable {
        private Vector<Integer> myVector;
        private int numberOfIterations;

        /**
         * Constructor.
         * @param vector vector
         * @param numberOfIterations number of iterations in run method
         */
        public ListJob(Vector<Integer> vector, int numberOfIterations) {
            this.myVector = vector;
            this.numberOfIterations = numberOfIterations;
        }

        /**
         * Implementation of run method of Runnable Interface.
         */
        @Override
        public void run() {
            try {
                for (int i = 0; i < numberOfIterations; i++) {
                    synchronized (myVector) {
                        if (!myVector.contains(i)) {
                            myVector.add(i);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }
}
