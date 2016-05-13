
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @author-Rui Wang rw1
 */
public class DirectoryDriver {

    /**
     * private values.
     */
    private JFrame frame;
    /**
     * private values.
     */
    private JPanel panelTotal;
    /**
     * private values.
     */
    private JPanel panel;
    /**
     * private values.
     */
    private JLabel label1;
    /**
     * private values.
     */
    private JTextField addFirstName;
    /**
     * private values.
     */
    private JLabel label2;
    /**
     * private values.
     */
    private JTextField addLastName;
    /**
     * private values.
     */
    private JLabel label3;
    /**
     * private values.
     */
    private JTextField addAndrewId;
    /**
     * private values.
     */
    private JLabel label4;
    /**
     * private values.
     */
    private JTextField addPhoneNum;
    /**
     * private values.
     */
    private JButton button1;
    /**
     * private values.
     */
    private JPanel panelDelete;
    /**
     * private values.
     */
    private JLabel labelDelete;
    /**
     * private values.
     */
    private JTextField textDelete;
    /**
     * private values.
     */
    private JButton buttonDelete;
    /**
     * private values.
     */
    private JPanel panelSearch;
    /**
     * private values.
     */
    private JLabel searchKeyLable;
    /**
     * private values.
     */
    private JTextField searchKeyText;
    /**
     * private values.
     */
    private JButton buttonAndrewId;
    /**
     * private values.
     */
    private JButton buttonFirstName;
    /**
     * private values.
     */
    private JButton buttonLastName;
    /**
     * private values.
     */
    private JPanel result;
    /**
     * private values.
     */
    private JTextArea textArea;
    /**
     * private values.
     */
    private static Directory direc;
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
     * private values.
     */
    private final int textSearchSize = 15;

    /**
     * constructor.
     */
    public DirectoryDriver() {

        frame = new JFrame("Homework 6 -- rw1");
        // frame.setSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(row, column);
        frame.setLayout(new BorderLayout());

        // The whole panel.
        panelTotal = new JPanel();
        panelTotal.setLayout(new BoxLayout(panelTotal, BoxLayout.Y_AXIS)); // set
                                                                           // layout

        /*
         * First panel use for add a new student.
         */
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // set layout
        panel.setBorder(BorderFactory.createTitledBorder("Add a new student")); // set
                                                                                // title
        label1 = new JLabel("First Name:");
        addFirstName = new JTextField("", textSize);
        panel.add(label1);
        panel.add(addFirstName);

        label2 = new JLabel("Last Name:");
        addLastName = new JTextField("", textSize);
        panel.add(label2);
        panel.add(addLastName);

        label3 = new JLabel("Andrew ID:");
        addAndrewId = new JTextField("", textSize);
        panel.add(label3);
        panel.add(addAndrewId);

        label4 = new JLabel("Phone Number:");
        addPhoneNum = new JTextField("", textSize);
        panel.add(label4);
        panel.add(addPhoneNum);

        // call these three method to build three panel deal with three operation.
        addStudent();
        deleteStudent();
        searchStudent();
        /*
         * Set at search key text.
         */
        frame.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                searchKeyText.requestFocusInWindow();
            }
        });

        /*
         * Set enter as search with andrew id.
         */
        @SuppressWarnings("serial")
        Action enter = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                String sIdText = searchKeyText.getText();
                if (!sIdText.equals("")) {
                    if (direc.searchByAndrewId(sIdText) != null) {
                        textArea.append(direc.searchByAndrewId(sIdText).toString() + "\n");
                        searchKeyText.setText("");
                    } else {
                        textArea.append("Searc by Andrew Id, no such Andrew Id student exists:"
                                + sIdText + "\n");
                    }
                } else {
                    textArea.append("Search key Missing\n");
                }
            }
        };
        searchKeyText.addActionListener(enter);

        /*
         * Forth panel use for show the result.
         */
        result = new JPanel();
        result.setBorder(BorderFactory.createTitledBorder("Results")); // set
                                                                       // title
        final int textRow = 20;
        final int textColumn = 55;
        textArea = new JTextArea(textRow, textColumn);
        textArea.setText("");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(textArea);
        result.add(scroller);

        panelTotal.add(panel);
        panelTotal.add(panelDelete);
        panelTotal.add(panelSearch);
        panelTotal.add(result);

        frame.add(panelTotal);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * add a new student.
     */
    public void addStudent() {
        button1 = new JButton("Add");
        panel.add(button1);
        // AddStudent add = new AddStudent();
        // button1.addActionListener(add);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                String aFirstName = addFirstName.getText();
                String aLastName = addLastName.getText();
                String aAndrewId = addAndrewId.getText();
                String aPhoneNum = addPhoneNum.getText();
                Student stu = null;
                String errMsg = "";
                if (aFirstName.equals("")) {
                    errMsg += "First Name missing\n";
                }
                if (aLastName.equals("")) {
                    errMsg += "Last Name missing\n";
                }
                if (aAndrewId.equals("")) {
                    errMsg += "Andrew ID missing\n";
                }
                if ((!aAndrewId.equals("")) && (!aFirstName.equals("")) && (!aLastName.equals(""))) {
                    if (direc.searchByAndrewId(aAndrewId) == null) {
                        stu = new Student(aFirstName, aLastName, aAndrewId, aPhoneNum);
                        direc.addStudent(stu);
                        textArea.append("Add a new student: " + stu.toString() + "\n");
                        addFirstName.setText("");
                        addLastName.setText("");
                        addAndrewId.setText("");
                        addPhoneNum.setText("");
                    } else {
                        textArea.append("Data already contains an entry for this Andrew ID\n");
                    }
                } else {
                    textArea.append(errMsg);
                }
            }
        });
    }
    /**
     * delete a student.
     */
    public void deleteStudent() {
        /*
         * Second panel use for delete a student.
         */
        panelDelete = new JPanel();
        panelDelete.setBorder(BorderFactory.createTitledBorder("Delelt a student")); // set
                                                                                     // title
        panelDelete.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelDelete = new JLabel("Andrew ID:");
        textDelete = new JTextField("", textSearchSize);
        panelDelete.add(labelDelete);
        panelDelete.add(textDelete);

        buttonDelete = new JButton("Delete");
        panelDelete.add(buttonDelete);
        // delete = new DeleteStudent();
        // buttonDelete.addActionListener(delete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                String dText = textDelete.getText();
                if (!dText.equals("")) {
                    if (direc.searchByAndrewId(dText) != null) {
                        textArea.append("Deleted a student: "
                    + direc.searchByAndrewId(dText).toString() + "\n");
                        direc.deleteStudent(dText);
                        textDelete.setText("");
                    } else {
                        textArea.append("There is no student with this andrew Id: "
                                + dText + "\n");
                    }
                } else {
                    textArea.append("Andrew ID missing\n");
                }
            }
        });
    }
    /**
     * search a student.
     */
    public void searchStudent() {
        /*
         * Third panel use for search a student based on andrew id, first name
         * and last name.
         */
        panelSearch = new JPanel();
        panelSearch.setBorder(BorderFactory.createTitledBorder("Search Student(s)")); // set
                                                                                      // title
        panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchKeyLable = new JLabel("Search Key:");
        searchKeyText = new JTextField("", textSearchSize);
        panelSearch.add(searchKeyLable);
        panelSearch.add(searchKeyText);

        buttonAndrewId = new JButton("By Andrew ID");
        panelSearch.add(buttonAndrewId);
        // SearchByAndewID id = new SearchByAndewID();
        // buttonAndrewId.addActionListener(id);
        buttonAndrewId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                String sIdText = searchKeyText.getText();
                if (!sIdText.equals("")) {
                    if (direc.searchByAndrewId(sIdText) != null) {
                        textArea.append(direc.searchByAndrewId(sIdText).toString() + "\n");
                        searchKeyText.setText("");
                    } else {
                        textArea.append("Searc by Andrew Id, no such Andrew Id student exists:"
                                        + sIdText + "\n");
                    }
                } else {
                    textArea.append("Search key Missing\n");
                }
            }
        });

        /*
         * Search a student by first name.
         */

        buttonFirstName = new JButton("By First Name");
        panelSearch.add(buttonFirstName);
        // SearchByFirstName firstName = new SearchByFirstName();
        // buttonFirstName.addActionListener(firstName);
        buttonFirstName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                String sFirstNameText = searchKeyText.getText();
                if (!sFirstNameText.equals("")) {
                    List<Student> stus = direc.searchByFirstName(sFirstNameText);
                    if (stus.size() != 0) {
                        for (int i = 0; i < stus.size(); i++) {
                            textArea.append(stus.get(i).toString() + "\n");
                        }
                        searchKeyText.setText("");
                    } else {
                        textArea.append(
                                "Searc by first name, no such First name student exists:"
                                        + sFirstNameText + "\n");
                    }
                } else {
                    textArea.append("Search key Missing\n");
                }
            }
        });

        /*
         * Search by last name.
         */
        buttonLastName = new JButton("By Last Name");
        panelSearch.add(buttonLastName);
        // SearchByLastName lastName = new SearchByLastName();
        // buttonLastName.addActionListener(lastName);
        buttonLastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                String sLastNameText = searchKeyText.getText();
                if (!sLastNameText.equals("")) {
                    List<Student> stus = direc.searchByLastName(sLastNameText);
                    if (stus.size() != 0) {
                        for (int i = 0; i < stus.size(); i++) {
                            textArea.append(stus.get(i).toString() + "\n");
                        }
                        searchKeyText.setText("");
                    } else {
                        textArea.append("Searc by Last name, no such Last name student exists:"
                                        + sLastNameText + "\n");
                    }
                } else {
                    textArea.append("Search key Missing\n");
                }
            }
        });
    }

    /**
     *
     * @param args
     *            for input.
     */
    public static void main(String[] args) {
        direc = new Directory();
        FileReader file;
        if (args.length == 0) {
            new DirectoryDriver();
        } else {
            try {
                file = new FileReader(args[0]); // input database file through
                                                // comment.
                @SuppressWarnings("resource")
                BufferedReader buff = new BufferedReader(file);
                boolean eof = false;
                @SuppressWarnings("unused")
                String line = buff.readLine();
                while (!eof) {
                    String eachStue = buff.readLine();
                    if (eachStue == null) {
                        eof = true;
                        break;
                    }
                    System.out.println(eachStue);
                    String[] infor = eachStue.split(",");
                    final int index0 = 0;
                    final int index1 = 1;
                    final int index2 = 2;
                    final int index3 = 3;
                    String readFirstName = infor[index0].substring(1, infor[index0].length() - 1);
                    String readLastName = infor[index1].substring(1, infor[index1].length() - 1);
                    String readAndrewId = infor[index2].substring(1, infor[index2].length() - 1);
                    String readPhoneNum = infor[index3].substring(1, infor[index3].length() - 1);

                    Student stu = new Student(readFirstName, readLastName,
                                                readAndrewId, readPhoneNum);
                    System.out.println(stu.toString());
                    direc.addStudent(stu);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new DirectoryDriver();
        }
    }
}
