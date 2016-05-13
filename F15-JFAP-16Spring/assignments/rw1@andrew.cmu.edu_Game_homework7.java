import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author-Rui Wang rw1
 */
public class Game implements ActionListener {

    /**
     * private values.
     */
    private static final int COUNTNUM = 20;
    /**
     * private values.
     */
    private static final int NUM2 = 64;
    /**
     * private values.
     */
    private static int count = COUNTNUM;
    /**
     * private values.
     */
    private int score = 0;
    /**
     * private values.
     */
    private int buttonNum = NUM2;
    /**
     * private values.
     */
    private static final String UP = "up";
    /**
     * private values.
     */
    private static final String DOWN = "hit";
    /**
     * private values.
     */
    private static final String OFF = "  ";
    /**
     * private values.
     */
    private static final Color UP_COLOR = Color.GREEN;
    /**
     * private values.
     */
    private static final Color DOWN_COLOR = Color.RED;
    /**
     * private values.
     */
    private static final Color OFF_COLOR = Color.LIGHT_GRAY;
    /**
     * private values.
     */
    private final JButton startButton;
    /**
     * private values.
     */
    private final JTextArea timeLeftArea;
    /**
     * private values.
     */
    private final JTextArea scoreArea;
    /**
     * private values.
     */
    private JFrame frame;
    /**
     * private values.
     */
    private JButton[] buttons;
    /**
     * private values.
     */
    private final int row = 340;
    /**
     * private values.
     */
    private final int column = 120;
    /**
     * private values.
     */
    private final int textSize = 5;

    /**
     * constructor.
     */
    public Game() {
        frame = new JFrame("Whack-a-mole Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(row, column);
        final int sizeRow = 650;
        final int sizeCol = 330;
        frame.setSize(sizeRow, sizeCol);

        JPanel paneTotal = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(this);

        paneTotal.add(startButton);

        JPanel paneText = new JPanel();
        timeLeftArea = new JTextArea(1, textSize);
        timeLeftArea.setEditable(false);
        JLabel time = new JLabel("time left:");
        paneText.add(time);
        paneText.add(timeLeftArea);
        JLabel scoreLabel = new JLabel("Score:");
        paneText.add(scoreLabel);
        scoreArea = new JTextArea(1, textSize);
        scoreArea.setEditable(false);
        paneText.add(scoreArea);

        JPanel paneButton = new JPanel();
        final int gridNum = 8;
        paneButton.setLayout(new GridLayout(gridNum, gridNum));
        buttons = new JButton[buttonNum];
        for (int i = 0; i < buttonNum; i++) {
            buttons[i] = new JButton(" ");
            paneButton.add(buttons[i]);
            buttons[i].setOpaque(true);
            buttons[i].setBackground(OFF_COLOR);
            buttons[i].addActionListener(this);
        }

        paneTotal.add(paneText);
        paneTotal.add(paneButton);
        frame.setContentPane(paneTotal);
        frame.setVisible(true);
    }

    /**
     *
     * @param args args
     */
    public static void main(String[] args) {
        new Game();
    }
    /**
     *
     * @author-Rui Wang rw1
     */
    private static class Mole extends Thread {
        /**
         * values.
         */
        private JButton button;

        /**
         *
         * @param button constructor.
         */
        Mole(JButton button) {
            this.button = button;
            if (count >= 0) {
                if (button.getText().equals(OFF)) {
                    button.setText(UP);
                    button.setBackground(UP_COLOR);
                } else {
                    button.setText(OFF);
                    button.setBackground(OFF_COLOR);
                }
            }
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            while (count >= 0) {
                final int numRandomTime = 5000;
                int randomTime = new Random().nextInt(numRandomTime);
                synchronized (button) {
                    if (button.getText().equals(OFF)) {
                        button.setText(UP);
                        button.setBackground(UP_COLOR);
                    } else {
                        button.setText(OFF);
                        button.setBackground(OFF_COLOR);
                    }
                }
                try {
                    Thread.sleep(randomTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    final int sleepTime = 1000;
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count < 0) {
                button.setText(OFF);
                button.setBackground(OFF_COLOR);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("Start");
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            Thread timeThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (count >= 0) {
                        try {
                            timeLeftArea.setText("" + count);
                            count--;
                            final int sleepTime1 = 1000;
                            Thread.sleep(sleepTime1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        final int finalSleepTime = 5000;
                        Thread.sleep(finalSleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // reset count and score
                    count = COUNTNUM;
                    score = 0;
                    timeLeftArea.setText("" + count);
                    scoreArea.setText("" + score);
                    startButton.setEnabled(true);

                }
            });
            // begin the time thread
            timeThread.start();
            // set thread for each mole
            Thread[] moles = new Thread[buttonNum];
            for (int i = 0; i < buttonNum; i++) {
                int randomMole = new Random().nextInt(buttonNum);
                JButton button = buttons[randomMole];
                moles[i] = new Mole(button);
                moles[i].start();
            }
        }
        // calculate score
        for (int i = 0; i < buttonNum; i++) {
            if (e.getSource() == buttons[i]) {
                // if it is in the game time
                if (count > 0) {
                    if (buttons[i].getText().equals(UP)) {
                        score++;
                        scoreArea.setText("" + score);
                        buttons[i].setText(DOWN);
                        buttons[i].setBackground(DOWN_COLOR);
                    }
                }
            }
        }
    }

}
