import java.util.ArrayList;
import java.util.List;

/**
 * Example code for ArrayList synchronization and race condition.
 * @author Terry Lee
 */
public class SyncArrayListDemo {

    /**
     * Program to demo race condition with arraylist and how to synchronize.
     * @param args arguments
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int numberOfIterations = 20;
        List<Integer> list = new ArrayList<Integer>();

        Thread t1 = new Thread(new ListJob(list, numberOfIterations));
        Thread t2 = new Thread(new ListJob(list, numberOfIterations));

        t1.start();
        t2.start();

        // Waits for these threads to terminate before checking the list state.
        t1.join();
        t2.join();

        for (int i = 0; i < list.size(); ++i) {
            System.out.println("Index at " + i + ": " + list.get(i));
        }

        System.out.println("Final size should be " + numberOfIterations
                + ", actual size: " + list.size());
    }

    /**
     * Static nested class that implements Runnable
     * @author Terry Lee
     */
    private static class ListJob implements Runnable {
        private List<Integer> myList;
        private int numberOfIterations;

        /**
         * Constructor.
         * @param list List
         * @param numberOfIterations number of iterations in run method
         */
        public ListJob(List<Integer> list, int numberOfIterations) {
            this.myList = list;
            this.numberOfIterations = numberOfIterations;
        }

        /**
         * Implementation of run method of Runnable Interface.
         */
        @Override
        public void run() {
            try {
                for (int i = 0; i < numberOfIterations; i++) {
                    if (!myList.contains(i)) {
                        myList.add(i);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }
}
