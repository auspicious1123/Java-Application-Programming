import javax.swing.JTextArea;

/**
 * Example code for Lecture 11 (Threads).
 * @author Jeff Eppinger & Terry Lee
 */
public class MyThread extends Thread {
    // unique state per thread instance
    /**
     * sleep time variable.
     */
    private long mySleepTimeInMillis;
    /**
     * area to display values.
     */
    private JTextArea area;

    /**
     * Constructor with sleep time and text are to display values.
     * @param sleepTimeInSecs sleep time value
     * @param a textarea to display text
     */
    public MyThread(int sleepTimeInSecs, JTextArea a) {
        mySleepTimeInMillis = sleepTimeInSecs * 1000;
        area = a;
    }

    /**
     * Implementation of run method of Runnable Interface.
     * Thread class implements Runnable Interface
     */
    @Override
    public void run() {
        Thread myThread = Thread.currentThread();
        try {
            while (true) {
                area.append("In \"MyThread.run()\": thread name: "
                        + myThread.getName() + "\n");
                Thread.sleep(mySleepTimeInMillis);
            }
        } catch (InterruptedException e) {
            area.append(myThread.getName() + ": Interrupted\n");
        }
    }
}
