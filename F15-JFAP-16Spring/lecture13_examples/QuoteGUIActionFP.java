import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class QuoteGUIActionFP {
    /**
     * button for obama.
     */
    private JButton obamaButton;
    /**
     * button for trump.
     */
    private JButton trumpButton;
    /**
     * Text area for quotes.
     */
    private JTextArea textArea;

    /**
     * Simple program to demo how to use lambda expressions for ActionListener.
     */
    public QuoteGUIActionFP() {
        JFrame frame = new JFrame("08-671 QuoteGUI Example");
        frame.setSize(520, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font(Font.SERIF, Font.BOLD, 20);

        JPanel pane = new JPanel();

        JLabel label = new JLabel("How about a presidential quote?");
        label.setFont(font);
        pane.add(label);

        JPanel line = new JPanel();

        obamaButton = new JButton("Barack Obama", new ImageIcon("obama.jpg"));
        obamaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        obamaButton.setHorizontalTextPosition(SwingConstants.CENTER);
        
        obamaButton.addActionListener(e -> textArea.append("Yes we can!\n"));

        line.add(obamaButton);

        trumpButton = new JButton("Donald Trump", new ImageIcon("trump.jpg"));
        trumpButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        trumpButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // anonymous class to add functionality to trump button
        trumpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("You're fired!\n");
            }
        });

        line.add(trumpButton);

        pane.add(line);

        textArea = new JTextArea(10, 40);
        textArea.setText("Click image for a presidential quote.\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scroller = new JScrollPane(textArea);
        pane.add(scroller);

        frame.setContentPane(pane);
        frame.setVisible(true);
    }

    /**
     * Run the program.
     * @param args arguments
     */
    public static void main(String[] args) {
        new QuoteGUIActionFP();
    }
}
