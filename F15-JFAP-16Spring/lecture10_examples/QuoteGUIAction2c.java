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
public class QuoteGUIAction2c extends JFrame {
    /**
     * Serial number.
     */
    private static final long serialVersionUID = 1L;

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
    public QuoteGUIAction2c() {
        setTitle("08-671 QuoteGUI Example");
        setSize(520, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font(Font.SERIF, Font.BOLD, 20);

        JPanel pane = new JPanel();

        JLabel label = new JLabel("How about a presidential quote?");
        label.setFont(font);
        pane.add(label);

        JPanel line = new JPanel();

        obamaButton = new JButton("Barack Obama", new ImageIcon("obama.jpg"));
        obamaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        obamaButton.setHorizontalTextPosition(SwingConstants.CENTER);
        line.add(obamaButton);

        trumpButton = new JButton("Donald Trump", new ImageIcon("trump.jpg"));
        trumpButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        trumpButton.setHorizontalTextPosition(SwingConstants.CENTER);
        line.add(trumpButton);
        
        pane.add(line);

        textArea = new JTextArea(10, 40);
        textArea.setText("Click image for a presidential quote.\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scroller = new JScrollPane(textArea);
        pane.add(scroller);

        obamaButton.addActionListener(new ObamaActionListener(textArea));
        trumpButton.addActionListener(new TrumpActionListener(textArea));

        setContentPane(pane);
        setVisible(true);
    }

    /**
     * Main method that instantiates GUI Object.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new QuoteGUIAction2c();
    }

    /**
     * Private static nested class used to provide actionPerformed() method to Swing.
     * @author Jeff Eppinger & Terry Lee
     */
    private static class ObamaActionListener implements ActionListener {
        private JTextArea area;

        public ObamaActionListener(JTextArea a) {
            area = a;
        }

        public void actionPerformed(ActionEvent event) {
            area.append("Yes we can!\n");
        }
    }

    /**
     * Private static nested class used to provide actionPerformed() method to Swing.
     * @author Jeff Eppinger & Terry Lee
     */
    private static class TrumpActionListener implements ActionListener {
        private JTextArea area;

        public TrumpActionListener(JTextArea a) {
            area = a;
        }

        public void actionPerformed(ActionEvent event) {
            area.append("You're Fired!\n");
        }
    }
}
