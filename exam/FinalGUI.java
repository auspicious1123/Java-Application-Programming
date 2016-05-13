import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Final GUI. 08-671 Java Final Programming Exam.
 * 
 * @author Yuheng Li(Andrew ID: yuhengl)
 * @version 1.0
 * @since Oct 22, 2015
 */
public class FinalGUI {
    //The final instance of FianlGUI
    static FinalGUI singleton;
    /**
     * Enum for all candidates.
     * @author Yuheng Li
     * @version 1.0
     * @since Oct 23, 2015
     */
    static enum Candidates {
        CLINTON, TRUMP;
        public String toString(){
            switch (this) {
                case CLINTON:
                    return "Clinton";
                case TRUMP:
                    return "Trump";
                default:
                    return "unname";
            }
        }
    }
    
    /**
     * Error Message enum.
     * 
     * @author Yuheng Li
     * @version 1.0
     * @since Oct 22, 2015
     */
    static enum ErrorMsg {
        AMOUNTINT, AMOUNTTOOBIG, AMOUNTTOOSMALL, LASTNAMEMISSING,
        FIRSTNAMEMISSING, AMOUNTMISSING;
        public String toString() {
            switch (this) {
                case AMOUNTINT:
                    return "**** The amount must be an integer ***\n";
                case AMOUNTTOOBIG:
                    return "**** Contribution is too large "
                            + "($ 9,999,999 is the maximum allowed) ***\n";
                case AMOUNTTOOSMALL:
                    return "**** Contribution is too small "
                            + "(You must contribute more than $ 0) ***\n";
                case LASTNAMEMISSING:
                    return "**** Please Enter your Last Name! ***\n";
                case FIRSTNAMEMISSING:
                    return "**** Please Enter your First Name! ***\n";
                case AMOUNTMISSING:
                    return "**** Please Enter a amount! ***\n";
                default:
                    return "";
            }
        }
    }

    public static FinalGUI getInstance() {
        if (singleton == null) {
            singleton = new FinalGUI();
        }
        return singleton;
    }

    // Instance Variables
    // GUI variables
    // Jframe
    private JFrame frame;
    // JPanel
    private JPanel mainPane;
    private JPanel pane1, pane2, pane3;
    private JScrollPane pane4;
    // JTextField.
    private JTextField textLastName, textFirstName, textAmount;
    // JTextArea
    private JTextArea textDisplay;
    // JButton
    private JButton btnVote4Clinton, btnVote4Trump, btnListClinton,
            btnListTrump;

    // data variables
    Map<Candidates, List<FinalData>> candidate2Contributors;
    float total = 0;
    // helper variable
    boolean isUnderListView = false;

    /**
     * constructor.
     */
    public FinalGUI() {
        // GUI initialization.
        InitGUI();
        // Data initialization.
        candidate2Contributors = new HashMap<Candidates, List<FinalData>>();
        candidate2Contributors.put(Candidates.CLINTON, new ArrayList<FinalData>());
        candidate2Contributors.put(Candidates.TRUMP, new ArrayList<FinalData>());
    }

    /**
     * Initialize GUI.
     */
    private void InitGUI() {
        frame = new JFrame();
        frame.setSize(720, 500);
        frame.setTitle("Campaign Contribution Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // Panel Setting
        mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
        // pane1
        pane1 = new JPanel();
        textLastName = new JTextField(5);
        textFirstName = new JTextField(5);
        textAmount = new JTextField(5);
        pane1.add(new JLabel("Contributor Last Name: "));
        pane1.add(textLastName);
        pane1.add(new JLabel("First Name: "));
        pane1.add(textFirstName);
        pane1.add(new JLabel("Amount: "));
        pane1.add(textAmount);
        // pane2
        pane2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        btnVote4Clinton = new JButton("Contribute to Clinton");
        btnVote4Clinton.addActionListener(e -> {
            onBtnVoteClick(Candidates.CLINTON);
        });
        btnVote4Trump = new JButton("Contribute to Trump");
        btnVote4Trump.addActionListener(e -> {
            onBtnVoteClick(Candidates.TRUMP);
        });
        pane2.add(btnVote4Clinton);
        pane2.add(btnVote4Trump);
        // pane3
        pane3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        btnListClinton = new JButton("List Clinton Contributors");
        btnListClinton.addActionListener(e -> {
            onBtnListClick(Candidates.CLINTON);
        });
        btnListTrump = new JButton("List Trump Contributors");
        btnListTrump.addActionListener(e -> {
            onBtnListClick(Candidates.TRUMP);
        });
        pane3.add(btnListClinton);
        pane3.add(btnListTrump);
        // pane4
        textDisplay = new JTextArea(15, 60);
        textDisplay.setText("");
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        textDisplay.setFont(font);
        textDisplay.setEditable(false);
        pane4 = new JScrollPane(textDisplay);
        // Assemble the panels
        mainPane.add(pane1);
        mainPane.add(pane2);
        mainPane.add(pane3);
        mainPane.add(pane4);
        /*
         * frame display
         */
        frame.setContentPane(mainPane);
        frame.pack();
        frame.setVisible(true);
    }

    // Button Click Events.
    /**
     * onBtnListClick.
     */
    private void onBtnListClick(Candidates candidate) {
        isUnderListView = true;
        clearTestArea();
        textDisplay.append(String
                .format("Contributions for %s:\n\n", candidate));
        printSortedVotes(candidate2Contributors.get(candidate));
    }

    /**
     * onBtnVoteClick.
     */
    private void onBtnVoteClick(Candidates candidate) {
        if (isUnderListView) {
            clearTestArea();
            isUnderListView = false;
        }
        if (blankCheck()) {
            FinalData vote = new FinalData(textLastName.getText(),
                    textFirstName.getText(), Integer.parseInt(textAmount
                            .getText()), candidate.toString());
            candidate2Contributors.get(candidate).add(vote);
            textDisplay.append(vote.toString());
            clearTextField();
        }
    }

    // helper methods.
    /**
     * sortVotes.
     * 
     * @param votes
     *            vote.
     */
    private void printSortedVotes(List<FinalData> votes) {
        Collections.sort(votes, (a, b) -> {
            return a.getFirstName().compareTo(b.getFirstName());
        });
        Collections.sort(votes, (a, b) -> {
            return a.getLastName().compareTo(b.getLastName());
        });
        Collections.sort(votes, (b, a) -> {
            return a.getAmount() - b.getAmount();
        });
        votes.forEach(e -> {
            textDisplay.append(e.toString());
            total += e.getAmount();
        });
        textDisplay.append(String.format("\n\t\t\t\t\tTotal:\t$%,10.0f\n",
                total));
        total = 0;
    }

    /**
     * blankCheck.
     * 
     * @return flag
     */
    private boolean blankCheck() {
        // check Last Name
        if (textLastName.getText().trim().length() == 0) {
            sendErrorMsg(ErrorMsg.LASTNAMEMISSING);
            return false;
        }
        // check first Name
        if (textFirstName.getText().trim().length() == 0) {
            sendErrorMsg(ErrorMsg.FIRSTNAMEMISSING);
            return false;
        }
        // check amount type
        try {
            String str = textAmount.getText();
            if (str.trim().length() == 0) {
                sendErrorMsg(ErrorMsg.AMOUNTMISSING);
                return false;
            }
            long num = Long.parseLong(str); // in case of super contribution
            if (num <= 0) {
                sendErrorMsg(ErrorMsg.AMOUNTTOOSMALL);
                return false;
            }
            if (num > 9999999) {
                sendErrorMsg(ErrorMsg.AMOUNTTOOBIG);
                return false;
            }
        } catch (Exception e) {
            sendErrorMsg(ErrorMsg.AMOUNTINT);
            return false;
        }
        return true;
    }

    /**
     * clear testArea display.
     */
    private void clearTestArea() {
        textDisplay.setText("");
    }

    /**
     * clear all textfields.
     */
    private void clearTextField() {
        textLastName.setText("");
        textFirstName.setText("");
        textAmount.setText("");
    }

    /**
     * send massage helper.
     * 
     * @param msg
     *            msg info
     */
    private void sendErrorMsg(ErrorMsg msg) {
        textDisplay.append(msg.toString());
    }

    /**
     * main.
     * 
     * @param args
     *            args
     */
    public static void main(String[] args) {
        FinalGUI.getInstance();
    }
}
