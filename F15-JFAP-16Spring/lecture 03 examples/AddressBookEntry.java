/**
 * An example of a class to represent an entry in an address book.
 *
 * @author Jeffrey Eppinger
 */
public class AddressBookEntry {
    String firstName;
    String lastName;
    String telephoneNumber;
    String eMailAddress;

    void print() {
        System.out.println("Name:   " + firstName +
                       " " + lastName);
        System.out.println("Tel:    " + telephoneNumber);
        System.out.println("E-Mail: " + eMailAddress);
        System.out.println();
    }

    public static void main(String[] args) {
        AddressBookEntry jeff = new AddressBookEntry();
        jeff.firstName = "Jeffrey";
        jeff.lastName  = "Eppinger";
        jeff.telephoneNumber = "412-268-7688";
        jeff.eMailAddress = "eppinger@cmu.edu";

        jeff.print();

        AddressBookEntry terry = new AddressBookEntry();
        terry.firstName = "Terry";
        terry.lastName  = "Lee";
        terry.telephoneNumber = "412-268-1476";
        terry.eMailAddress = "terrylee@cs.cmu.edu";

        terry.print();

        AddressBookEntry barry = new AddressBookEntry();
        barry.firstName = "Barack";
        barry.lastName  = "Obama";
        barry.telephoneNumber = "202-456-1111";
        barry.eMailAddress = "potus@whitehouse.gov";

        barry.print();
    }
}
