/**
 * Example code for lecture 6 (Static member and method).
 * @author Jeffrey Eppinger & Terry Lee
 */
public final class Customer {
    /**
     * static variable to keep track of last customer number.
     */
    private static int lastCustNum = 0;

    /**
     * static method to get number of customers.
     * @return int value for number of customers
     */
    public static int getNumCustomers() {
        return lastCustNum / 11;
    }

    /**
     * customer number instance variable.
     */
    private int customerNumber;
    /**
     * first name of customer.
     */
    private String firstName;
    /**
     * last name of customer.
     */
    private String lastName;

    /**
     * Constructor with first name and last name.
     * @param first first name
     * @param last last name
     */
    public Customer(String first, String last) {
        firstName = first;
        lastName = last;
        lastCustNum += 11;
        customerNumber = lastCustNum;
    }

    /**
     * Getter for first name.
     * @return first name string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for last name.
     * @return last name string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for customer number.
     * @return int value of customer number
     */
    public int getCustNum() {
        return customerNumber;
    }

    /**
     * Setter for first name.
     * @param s string first name
     */
    public void setFirstName(String s) {
        firstName = s;
    }

    /**
     * Setter for last name.
     * @param s string last name
     */
    public void setLastName(String s) {
        lastName = s;
    }

    /**
     * Returns string representation of customer object.
     * @return string representation of customer object
     */
    public String toString() {
        return "Customer(#" + customerNumber + ", " + lastName + ", " + firstName + ") of " + lastCustNum / 11
                + " customers";
    }

}
