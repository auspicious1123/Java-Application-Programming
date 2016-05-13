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
 * Example with long-running task in actionPerformed.
 * @author Jeff Eppinger & Terry Lee
 */
public class ActionLoop implements ActionListener {
    /**
     * JButton.
     */
    private JButton button;
    /**
     * Name field.
     */
    private JTextField nameField;
    /**
     * Text area to print status.
     */
    private JTextArea textArea;

    /**
     * Constructor.
     */
    public ActionLoop() {
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 16);
        Font textFont = new Font(Font.MONOSPACED, Font.BOLD, 14);

        JFrame frame = new JFrame("A Swing App to Demonstrate Threads Running");
        frame.setSize(650, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        JLabel label = new JLabel("Name: ");
        label.setFont(labelFont);
        pane.add(label);

        nameField = new JTextField(20);
        nameField.setFont(textFont);
        nameField.addActionListener(this);
        pane.add(nameField);

        button = new JButton("Start");
        button.setFont(buttonFont);
        button.addActionListener(this);
        pane.add(button);

        textArea = new JTextArea(30, 70);
        textArea.setEditable(false);
        textArea.setFont(textFont);
        JScrollPane scroller = new JScrollPane(textArea);
        pane.add(scroller);

        frame.setContentPane(pane);
        frame.setVisible(true);
    }

    /**
     * Implementation of actions.
     * @param evt ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        String name = nameField.getText();
        // clear the field
        nameField.setText("");

        // long-running task
        try {
            while (true) {
                String status = name + ": " + System.currentTimeMillis() + "\n";
                System.out.println(status);
                textArea.append(status);
                // sleep for 1 second
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            textArea.append("Interrupted\n");
        }
    }

    /**
     * Test program to show thread information.
     * @param args arguments
     */
    public static void main(String[] args) {
        Thread myThread = Thread.currentThread();
        System.out.println("In method \"main()\".  Thread is named: " + myThread.getName());

        new ActionLoop();

        System.out.println("main() method is done.");
    }
}
