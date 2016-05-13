/**
 * An extension of the address book entry exam example, without
 * using subclasses.
 *
 * @author Jeffrey Eppinger
 */
public class AddressBookEntry2 {
    String firstName;
    String lastName;
    String telephoneNumber;
    String eMailAddress;
    int    age;

    void print() {
        System.out.println("Name:   " + firstName +
                       " " + lastName);
        System.out.println("Tel:    " + telephoneNumber);
        System.out.println("E-Mail: " + eMailAddress);
        System.out.println("Age     " + age);
        System.out.println();
    }

    void birthday() {
        age = age + 1;
    }

    public static void main(String[] args) {
        AddressBookEntry2 jeff = new AddressBookEntry2();
        jeff.firstName = "Jeffrey";
        jeff.lastName  = "Eppinger";
        jeff.telephoneNumber = "412-268-7688";
        jeff.eMailAddress = "eppinger@cmu.edu";
        jeff.age = 55;

        jeff.print();

        AddressBookEntry2 terry = new AddressBookEntry2();
        terry.firstName = "Terry";
        terry.lastName  = "Lee";
        terry.telephoneNumber = "412-268-1476";
        terry.eMailAddress = "terrylee@cs.cmu.edu";
        terry.age = 33;

        terry.print();

        AddressBookEntry2 barry = new AddressBookEntry2();
        barry.firstName = "Barack";
        barry.lastName  = "Obama";
        barry.telephoneNumber = "202-456-1111";
        barry.eMailAddress = "potus@whitehouse.gov";
        barry.age = 54;

        barry.print();

        jeff.birthday();
        terry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();

        jeff.print();
        terry.print();
        barry.print();
    }
}
