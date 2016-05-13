/**
 * Final Data. 08-671 Java Final Programming Exam.
 * @author Yuheng Li(Andrew ID: yuhengl)
 * @version 1.0
 * @since Oct 22, 2015
 */
public class FinalData {
    private static int index = 0;
    // instance variables
    private String lastName, firstName, candidate;
    private int amount, idx;

    /**
     * constructor.
     * @param lName
     *            last name
     * @param fName
     *            first name
     * @param amt
     *            amount
     * @param cand
     *            candidate name
     */
    public FinalData(String lName, String fName, int amt, String cand) {
        this.lastName = lName.trim();
        this.firstName = fName.trim();
        this.amount = amt;
        this.candidate = cand;
        this.idx = index++;
    }

    // getters.
    public String getCandidate() {
        return candidate;
    }

    public static int getIndex() {
        return index;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAmount() {
        return amount;
    }

    public int getIdx() {
        return idx;
    }

    // override toString method.
    public String toString() {
        String name = String.format("%s, %s", lastName, firstName);
        if (name.length() > 15) {
            name = name.substring(0, 15);
        }
        if (name.length() < 8) {
            name = name + "\t";
        }
        StringBuilder moneyStr = new StringBuilder();
        moneyStr.append("$ ");
        float money = amount;
        return String
                .format("%s\t\t%s\t\t\t$%,10.0f\n", candidate, name, money);
    }
}
