import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Example code for Lecture 11 (Threads).
 * @author Jeff Eppinger & Terry Lee
 */
public class MyThreadWindow1 implements ActionListener {
    /**
     * button variable.
     */
    private JButton button;
    /**
     * name text field.
     */
    private JTextField nameField;
    /**
     * text area to display values.
     */
    private JTextArea textArea;
    /**
     * sleep time variable with initial value.
     */
    private int sleepTimeInSecs = 0;

    /**
     * Constructor to launch SwingGUI app to demo thread running.
     */
    public MyThreadWindow1() {
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 17);
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 17);
        Font textFont = new Font(Font.MONOSPACED, Font.BOLD, 17);

        JFrame frame = new JFrame("A Swing Application to Demonstrate Threads Running");
        frame.setSize(650, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        JLabel label = new JLabel("Name: ");
        label.setFont(labelFont);
        pane.add(label);

        nameField = new JTextField(20);
        nameField.setFont(textFont);
        // make pushing enter button to start a new thread
        nameField.addActionListener(this);
        pane.add(nameField);

        button = new JButton("Start a New Thread");
        button.setFont(buttonFont);
        // make clicking the button to start a new thread
        button.addActionListener(this);
        pane.add(button);

        textArea = new JTextArea(25, 60);
        textArea.setEditable(false);
        textArea.setFont(textFont);
        JScrollPane scroller = new JScrollPane(textArea);
        pane.add(scroller);

        frame.setContentPane(pane);
        frame.setVisible(true);
    }

    /**
     * Implementation of actionPerformed method of ActionLister interface.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        sleepTimeInSecs++;

        Thread myThread = Thread.currentThread();
        textArea.append("In method \"actionPerformed()\": Thread is named: " + myThread.getName() + "\n"
                + "   Creating a new thread \"" + nameField.getText() + "\", sleeps for " + sleepTimeInSecs
                + " seconds\n");

        // uses MyRunnable and Thread instances
        MyRunnable r = new MyRunnable(sleepTimeInSecs, textArea);
        Thread t = new Thread(r);
        t.setName(nameField.getText());
        t.start();

        // clear the field
        nameField.setText("");
    }

    /**
     * Execute program to demo Thread running with given names.
     * @param args arguments
     */
    public static void main(String[] args) {
        Thread myThread = Thread.currentThread();
        System.out.println("In method \"main()\".  Thread is named: " + myThread.getName());

        new MyThreadWindow1();

        System.out.println("Thread named " + myThread.getName() + " is done.");
    }
}
