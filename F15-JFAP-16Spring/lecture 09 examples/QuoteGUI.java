import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class QuoteGUI {

    /**
     * Constructor where JFrame and other components are instantiated.
     */
    public QuoteGUI() {
        JFrame frame = new JFrame("08-671 QuoteGUI Example");
        frame.setSize(520, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font(Font.SERIF, Font.BOLD, 20);

        JPanel pane = new JPanel();

        JLabel label = new JLabel("How about a presidential quote?");
        label.setFont(font);
        pane.add(label);

        JPanel line = new JPanel();

        ImageIcon obamaIcon = new ImageIcon("obama.jpg");
        JButton obamaButton = new JButton("Barack Obama", obamaIcon);
        obamaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        obamaButton.setHorizontalTextPosition(SwingConstants.CENTER);
        line.add(obamaButton);

        ImageIcon trumpIcon = new ImageIcon("trump.jpg");
        JButton trumpButton = new JButton("Donald Trump", trumpIcon);
        trumpButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        trumpButton.setHorizontalTextPosition(SwingConstants.CENTER);
        line.add(trumpButton);

        pane.add(line);

        JTextArea area = new JTextArea(10, 40);
        area.setText("Yes We Can!");
        pane.add(area);

        frame.setContentPane(pane);
        frame.setVisible(true);
    }


    /**
     * Simple program to show cookbook programming for Swing.
     * @param args arguments
     */
    public static void main(String[] args) {
        new QuoteGUI();
    }
}
