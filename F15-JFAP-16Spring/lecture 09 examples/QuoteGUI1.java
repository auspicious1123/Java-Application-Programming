import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class QuoteGUI1 {
    /**
     * Constructor where JFrame and other components are instantiated.
     */
    public QuoteGUI1() {
        JFrame frame = new JFrame("08-671 QuoteGUI Example");
        frame.setSize(520, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        Font bigFont = new Font(Font.SERIF, Font.BOLD, 20);

        JLabel label = new JLabel("How about a presidential quote?");
        label.setFont(bigFont);
        pane.add(label);

        JPanel line = new JPanel();

        JButton button = new JButton(new ImageIcon("obama.jpg"));
        line.add(button);

        JButton button2 = new JButton(new ImageIcon("trump.jpg"));
        line.add(button2);

        pane.add(line);

        JTextArea area = new JTextArea(10, 40);
        area.setText("Yes, we can.");
        pane.add(area);

        frame.setContentPane(pane);
        frame.setVisible(true);
    }

    /**
     * Simple program to show cookbook programming for Swing.
     * @param args arguments
     */
    public static void main(String[] args) {
        new QuoteGUI1();
    }
}
