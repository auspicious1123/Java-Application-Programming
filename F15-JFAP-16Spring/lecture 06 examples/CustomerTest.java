/**
 * Example code for lecture 6.
 * A simple test code for Customer (static members)
 * @author Jeffrey Eppinger & Terry Lee
 */
public class CustomerTest {
    /**
     * A simple program to use static method.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println(Customer.getNumCustomers() + " customers");

        Customer[] list = new Customer[5];
        list[0] = new Customer("George", "Bush");
        list[1] = new Customer("Barack", "Obama");
        list[2] = new Customer("Bill", "Clinton");
        list[3] = new Customer("Jeb", "Bush");
        list[4] = new Customer("Hillary", "Clinton");

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        System.out.println(Customer.getNumCustomers() + " customers");
    }
}
