/**
 * @author-Rui Wang rw1
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FinalGUI {
    private static JFrame frame;
    private JPanel totalPanel;
    private JTextArea textArea;
    private HashMap<String, FinalData> sellMap = new HashMap<>();
    private HashMap<String, Integer> buyMap = new HashMap<>();
    private ArrayList<String> buyItemsTotal = new ArrayList<>();
    private JTextField sellItemName;
    private JTextField itemPrice;
    private JTextField quantity;
    private JTextField buyItemName;
    private JTextField cashTendered;
    private double totalCash = 0;

    public FinalGUI() {
        frame = new JFrame();
        totalPanel = new JPanel();
        frame.setSize(720, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Cash Register");

        // panel 1: line 1
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Name of New Item to Sell:"));
        sellItemName = new JTextField("", 8);
        panel1.add(sellItemName);
        panel1.add(new JLabel("Price:"));
        itemPrice = new JTextField("", 8);
        panel1.add(itemPrice);
        JButton addItemButtonToStore = new JButton("Add Item to Store");
        panel1.add(addItemButtonToStore);
        addItemButtonToStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sellItem = sellItemName.getText();
                if (sellMap.containsKey(sellItem)) {
                    textArea.append("***Error: Item already for ale at this store.***\n");
                    return;
                }
                if (sellItem.trim().equals("")) {
                    textArea.append("***Error: Missing item name.***\n ");
                    return;
                }
                double sellPrice;
                String priceString = itemPrice.getText();
                if (priceString.trim().equals("")) {
                    textArea.append("***Error: Missing price input.***\n");
                    return;
                }
                try {
                    sellPrice = Double.parseDouble(priceString);
                } catch (Exception e1) {
                    textArea.append("***Error: Price is not a float number.***\n");
                    return;
                }
                if (sellPrice <= 0) {
                    textArea.append("***Error: Price is not greater than 0.***\n");
                    return;
                }
                FinalData newSellItem = new FinalData(sellItem, sellPrice);
                
                sellMap.put(newSellItem.getItem(), newSellItem); // ADD to map
                textArea.append("New item for sale: " + newSellItem.toString() + "\n");
            }
        });
        totalPanel.add(panel1);

        // panel 2: line 2
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Quantity Being Purchased:"));
        quantity = new JTextField("", 8);
        panel2.add(quantity);
        panel2.add(new JLabel("Item Name:"));
        buyItemName = new JTextField("", 8);
        panel2.add(buyItemName);
        JButton addItemButtonToBill = new JButton("Add Item to Customer Bill");
        panel2.add(addItemButtonToBill);
        addItemButtonToBill.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int quantityNum;
                String quantityString = quantity.getText();
                if (quantityString.trim().equals("")) {
                    textArea.append("***Error:  Missing Quantity input.***\n");
                    return;
                }
                try {
                    quantityNum = Integer.parseInt(quantityString);
                } catch (Exception e1) {
                    textArea.append("***Error: Quantity is not  an integer.***\n");
                    return;
                }

                String buyItemNameCustomer = buyItemName.getText();
                if (buyItemNameCustomer.trim().equals("")) {
                    textArea.append("***Error: Missing buy item name.***\n");
                    return;
                }
                buyMap.put(buyItemNameCustomer, quantityNum); // save the items
                                                              // buy by user
                FinalData buyItemInfor = null;
                if (sellMap.containsKey(buyItemNameCustomer)) {
                    buyItemInfor = sellMap.get(buyItemNameCustomer);
                } else {
                    textArea.append("***Error: No such Item.***\n");
                    return;
                }
                String infor = showBuyInfor(quantityNum, buyItemInfor);
                buyItemsTotal.add(infor);
                textArea.append(infor + "\n");
                totalCash += quantityNum * buyItemInfor.getPrice();

            }
        });
        totalPanel.add(panel2);

        // panel 3 : line 3
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Cash Tendered:"));
        cashTendered = new JTextField("", 8);
        panel3.add(cashTendered);
        JButton payButton = new JButton("Pay");
        panel3.add(payButton);
        payButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double cash;
                String cashString = cashTendered.getText();
                if (cashString.trim().equals("")) {
                    textArea.append("***Error: Missing cash tendered input.***\n");
                    return;
                }
                try {
                    cash = Double.parseDouble(cashString);
                } catch (Exception e1) {
                    textArea.append("***Error: Cash tendered is not a float number.***\n");
                    return;
                }
                double change = cash - totalCash;
                textArea.setText("");
                for (int i = 0; i < buyItemsTotal.size(); i++) {
                    textArea.append(buyItemsTotal.get(i) + "\n");
                }
                if (change < 0) {
                    String err1 = "***Error: Not enough cash, Must be at least  $";
                    String err2 = "***";
                    String notEnoughErr = String.format("%s %.2f %S", err1, totalCash, err2);
                    textArea.append(notEnoughErr);
                    return;
                } else {
                    textArea.append("\n\t\t\t\t\t" + "Total        \t $" + String.format("%,6.2f", totalCash));
                    textArea.append("\n\t\t\t\t\t" + "Cash Tendered\t $" + String.format("%,6.2f", (float) cash));
                    textArea.append("\n\t\t\t\t\t" + "Change       \t $" + String.format("%,6.2f", (float) change));
                    textArea.append("\n");
                }
                if(buyMap.isEmpty()) {
                    textArea.setText("");
                    textArea.append("You do not choose any item or you have paid.\n");
                }
                buyItemsTotal = new ArrayList<>();
                buyMap = new HashMap<>(); // clear all items
                totalCash = 0;
            }
        });
        JButton clearTextArea = new JButton("Clear Text Area");
        panel3.add(clearTextArea);
        clearTextArea.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        totalPanel.add(panel3);

        // panel 4: text area
        JPanel panel4 = new JPanel();
        textArea = new JTextArea(20, 80);
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        textArea.setFont(font);
        textArea.setEditable(false);
        panel4.add(new JScrollPane(textArea)); // set scroll
        totalPanel.add(panel4);

        frame.add(totalPanel);
        frame.setVisible(true);
        // frame.pack();
    }

    public String showBuyInfor(int buyNum, FinalData finalData) {
        double totalPrice = buyNum * finalData.getPrice();
        double eachPrice = finalData.getPrice();
        String name = finalData.getItem();

        if (name.length() < 16) {
            for (int i = name.length(); i < 16; i++) {
                name = name + " ";
            }
        }

        return String.format("%d %s\t\tat $%,6.2f each\t $ %,6.2f", buyNum, name, (float) eachPrice,
                (float) totalPrice);
    }

    public static void main(String[] args) {
        new FinalGUI();
    }

}
