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
 * Example recipe for Swing and ActionListener.
 * @author Jeff Eppinger & Terry Lee
 */
public class QuoteGUIAction1d {
    /**
     * Reference to the Obama button.
     */
    private JButton obamaButton;
    /**
     * Reference to the Trump button.
     */
    private JButton trumpButton;
    /**
     * Reference to the text area.
     */
    private JTextArea textArea;

    /**
     * Constructor where JFrame and other components are instantiated.
     */
    public QuoteGUIAction1d() {
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

        // anonymous class that implements ActionListener
        obamaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Yes we can!\n");
            }
        });
        line.add(obamaButton);

        trumpButton = new JButton("Donald Trump", new ImageIcon("trump.jpg"));
        trumpButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        trumpButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // anonymous class that implements ActionListener
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
     * Main method that instantiates GUI Object.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new QuoteGUIAction1d();
    }
}
