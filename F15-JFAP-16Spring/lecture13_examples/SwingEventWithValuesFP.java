import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Example for Lecture 13 (Functional Programming).
 * @author Terry Lee & Jeffrey Eppinger
 */
public class SwingEventWithValuesFP {

    /**
     * Simple program to demo lambda expression for actionlistener.
     * @param args arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SwingEventWithValues <nameToPrint>");
            System.exit(1);
        }

        String name = args[0];
        JFrame window = new JFrame("Before Java 8");
        JPanel pane = new JPanel();
        JButton button = new JButton("Who are you?");

        button.addActionListener(e -> {
            // local variables declared in enclosing scope
            // should be final or effectively final
            //name = "Jeff and he is awesome";
            System.out.println("I am " + name);
        });

        pane.add(button);
        window.add(pane);
        window.setSize(300, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
